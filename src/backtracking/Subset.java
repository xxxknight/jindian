package backtracking;

/**
 题目描述
 请编写一个方法，返回某集合的所有非空子集。
 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。
 各子集的顺序为其元素p从大到小排序后按字典序从大到小，见样例。
 测试样例：
 [123,456,789]
 返回：[[789],[456,789],[456],[123,789],[123,456,789],[123,456],[123]]
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 解题思路： 在n-1个数的所有子集的基础上生成n个数的所有子集，sets(n)通过如下步骤获得： 1.
 * 在sets(n-1)的所有子集前边插入当前元素A[n-1]。 2. A[n-1]单独作为一个子集[A[n-1]]。 3.
 * sets(n-1)同时也应包含到sets(n)中。 举个例子： A={1,2,3}; 1.首先生成一个元素的子集sets(1)={{1}}。
 * 2.加入元素2，则sets(2)由三部分组成： （1）在sets(1)的所有子集前边插入当前元素A[1]=2，得到{{2,1}}；
 * （2）A[1]单独作为一个子集{2}； （3）sets(1)同时也应包含到sets(2)中，sets(3) = {{2,1},{2},{1}}。
 * 3.加入元素3，则sets(3)由三部分组成： （1）在sets(2)的所有子集前边插入当前元素A[2]=3，得到
 * {{3,2,1},{3,2},{3,1}}； （2）A[2]单独作为一个子集{3}； （3）sets(2)同时也应包含到sets(3)中，sets(3)
 * = {{3,2,1},{3,2},{3,1},{3},{2,1},{2},{1}}。
 * 
 * @author founder
 * 
 */
public class Subset {
	public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		if (A == null || A.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(A);// 数组A从小到大排序
		return getSubsetsCore(A, n);
	}

	public ArrayList<ArrayList<Integer>> getSubsetsCore(int[] A, int n) {
		ArrayList<ArrayList<Integer>> outter = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner;
		if (n == 1) {// 循环终止条件
			inner = new ArrayList<Integer>();
			inner.add(A[0]);
			outter.add(inner);
			return outter;
		}
		ArrayList<ArrayList<Integer>> tmp = getSubsetsCore(A, n - 1);
		int i, j;
		for (i = 0; i < tmp.size(); i++) {// 1. 在sets(n-1)的所有子集前边插入当前元素A[n-1]。
			inner = new ArrayList<Integer>();
			inner.add(A[n - 1]);
			for (j = 0; j < tmp.get(i).size(); j++) {
				inner.add(tmp.get(i).get(j));
			}
			outter.add(inner);
		}
		inner = new ArrayList<Integer>();
		inner.add(A[n - 1]);
		outter.add(inner);// 2. A[n-1]单独作为一个子集[A[n-1]]。
		outter.addAll(tmp);// 3. sets(n-1)同时也应包含到sets(n)中。
		return outter;
	}

	public static void main(String[] args) {
		System.out.println(new Subset().getSubsets(new int[] { 0, 1, 2, 3, 4,
				5, 6, 7, 8, 9 }, 10));
	}
}