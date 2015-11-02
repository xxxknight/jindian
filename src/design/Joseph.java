package design;

/**
 * 题目描述
 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 测试样例：
 5
 返回：5
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