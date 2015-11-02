package design;

import java.util.ArrayList;

/**
 * ��Ŀ����
 * 
 * ��ʵ��һ�����ݽṹSetOfStacks���ɶ��ջ��ɣ�����ÿ��ջ�Ĵ�СΪsize����ǰһ��ջ����ʱ���½�һ��ջ��
 * �����ݽṹӦ֧������ͨջ��ͬ��push��pop������ ����һ����������int[][2]
 * ope(C++Ϊvector<vector<int>>)��ÿ�������ĵ�һ���������������
 * ����Ϊ1����Ϊpush��������һ����ΪӦpush�����֣���Ϊ2����Ϊpop����
 * ����һ���������塣�뷵��һ��int[][](C++Ϊvector<vector
 * <int>>)��Ϊ������в������SetOfStacks��˳��ӦΪ���µ��ϣ�Ĭ�ϳ�ʼ��SetOfStacksΪ�ա���֤���ݺϷ���
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