package design;

import java.util.ArrayList;

/**
 * 题目描述
 * 
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 * 该数据结构应支持与普通栈相同的push和pop操作。 给定一个操作序列int[][2]
 * ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型
 * ，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作
 * ，后一个数无意义。请返回一个int[][](C++为vector<vector
 * <int>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 * 
 * @author founder
 * 
 */

public class SetOfStacks {

	public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		// write code here
		if (null == ope || size <= 0) {
			return null;
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cur = new ArrayList<Integer>();
		res.add(cur);
		for (int i = 0; i < ope.length; i++) {

			if (ope[i][0] == 1) {
				if (cur.size() == size) {
					cur = new ArrayList<Integer>();
					res.add(cur);
				}
				cur.add(ope[i][1]);
			} else if (ope[i][0] == 2) {
				if (cur.isEmpty()) {
					res.remove(res.size() - 1);
					cur = res.get(res.size() - 1);
				}

				cur.remove(cur.size() - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] ope = { { 1, 97868 }, { 1, 69995 }, { 1, 28525 }, { 1, 72341 },
				{ 1, 86916 }, { 1, 5966 }, { 2, 58473 }, { 2, 93399 },
				{ 1, 84955 }, { 1, 16420 } };
		System.out.println(new SetOfStacks().setOfStacks(ope, 2));
	}
}