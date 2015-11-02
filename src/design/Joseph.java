package design;

/**
 * ��Ŀ����
 Լɪ��������һ��������Ȥ�⡣�������������޸�һ�¹�����n����վ��һ�С�����ͷ��β�����Ǳ�ţ���һ���˱��Ϊ1��
 Ȼ���ͷ��ʼ��������һ�����α�1��2��1��2...Ȼ�󱨵�2���˳��֡����ŵڶ����ٴ���һ�����һ���������˿�ʼ���α�1��2��3��1��2��3...����2��3���˳��֡�
 �Դ�����ֱ��ʣ���Ժ�һ���ˡ�������Ҫ��ļ�������˵ı�š�
 ����һ��int n��������Ϸ���������뷵�����һ���˵ı��
 ����������
 5
 ���أ�5
 */

import java.util.LinkedList;

public class Joseph {
	public int getResult(int n) {
		// write code here
		if (n <= 0) {
			return -1;
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		int round = 2;
		return helper(queue, round);
	}

	public int helper(LinkedList<Integer> list, int round) {
		if (list.size() == 1) {
			return list.peek();
		}
		int cur = 0;
		for (int i = 0; i < list.size();) {
			cur = (cur + 1) % round;
			if (cur != 1) {
				list.remove(i);
			} else {
				i++;
			}
		}
		list.addFirst(list.pollLast());
		return helper(list, round + 1);
	}

	public static void main(String[] args) {
		System.out.println(new Joseph().getResult(5));
	}
}