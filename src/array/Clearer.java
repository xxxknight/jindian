package array;

import java.util.ArrayList;

/**
 * ��Ŀ����
 * 
 * ���дһ���㷨����MxN������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
 * ����һ��MxN��int[][]����(C++��Ϊvector>)mat�;���Ľ���n���뷵����ɲ������int
 * [][]����(C++��Ϊvector>)����֤nС�ڵ���300�������е�Ԫ��Ϊint��Χ�ڡ� ����������
 * [[1,2,3],[0,1,2],[0,0,1]] ���أ�[[0,0,3],[0,0,0],[0,0,0]]
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
