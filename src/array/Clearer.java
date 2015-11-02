package array;

import java.util.ArrayList;

/**
 * 题目描述
 * 
 * 请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。
 * 给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int
 * [][]矩阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。 测试样例：
 * [[1,2,3],[0,1,2],[0,0,1]] 返回：[[0,0,3],[0,0,0],[0,0,0]]
 * 
 * @author founder
 * 
 */

public class Clearer {
	public int[][] clearZero(int[][] mat, int n) {
		// write code here
		int row = mat.length;
		int col = mat[0].length;

		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < col; j++) {
				mat[rows.get(i)][j] = 0;
			}
		}

		for (int i = 0; i < cols.size(); i++) {
			for (int j = 0; j < row; j++) {
				mat[j][cols.get(i)] = 0;
			}
		}
		return mat;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3 }, { 0, 1, 2 }, { 0, 0, 1 } };
		System.out.println(new Clearer().clearZero(mat, 3));

	}
}
