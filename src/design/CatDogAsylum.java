package design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * ��Ŀ����
 * 
 * �мҶ���������ֻ����è�͹��������������������������������������ʽ�� ��һ��Ϊֱ���������ж�������������������ģ��ڶ���Ϊѡ�������Ķ������ͣ�è�򹷣���
 * ���������ֶ�������������������ġ� ����һ����������int[][2]
 * ope(C++��Ϊvector<vector<int>>)���������¼�������һ��Ԫ��Ϊ1
 * ��������ж���������������ڶ���Ԫ��Ϊ����ı�ţ�������������������è
 * ������һ��Ԫ��Ϊ2�������������������ڶ���Ԫ����Ϊ0�����ȡ��һ��������ʽ����Ϊ1 ����ָ������������Ϊ-1��ָ������è���밴˳�򷵻����������С�
 * �����ֲ��Ϸ��Ĳ�������û�п��Է�������Ҫ��Ķ�� ����������������ԡ� ���������� [[1,1],[1,-1],[2,0],[2,-1]]
 * ���أ�[1,-1]
 * 
 * @author founder
 * 
 */

public class CatDogAsylum {
	private Deque<Integer> queue = new ArrayDeque<Integer>(); // ���д洢è��Ԫ��
	private Stack<Integer> temp = new Stack<Integer>(); // ����ջ

	public ArrayList<Integer> asylum(int[][] ope) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (null == ope) {
			return res;
		}
		for (int i = 0; i < ope.length; i++) {
			if (ope[i][0] == 1) {
				queue.offer(ope[i][1]);
			} else if (ope[i][0] == 2) {
				if (ope[i][1] == 0) {
					res.add(queue.poll());
				} else if (ope[i][1] == 1) {
					while (!queue.isEmpty() && queue.peek() <= 0) {
						temp.add(queue.poll());
					}
					if (!queue.isEmpty()) {
						res.add(queue.poll());
					}
					while (!temp.isEmpty()) {
						queue.addFirst(temp.pop());
					}
				} else if (ope[i][1] == -1) {
					while (!queue.isEmpty() && queue.peek() >= 0) {
						temp.add(queue.poll());
					}
					if (!queue.isEmpty()) {
						res.add(queue.poll());
					}
					while (!temp.isEmpty()) {
						queue.addFirst(temp.pop());
					}
				}
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ope = { { 1, -5 }, { 1, -1 }, { 1, 9 }, { 1, 9 }, { 2, 0 },
				{ 2, 1 }, { 1, -8 } };
		System.out.println(new CatDogAsylum().asylum(ope));

	}

}
