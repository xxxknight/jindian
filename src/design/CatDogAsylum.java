package design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * 题目描述
 * 
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式， 第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），
 * 并收养该种动物中最早进入收容所的。 给定一个操作序列int[][2]
 * ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1
 * ，则代表有动物进入收容所，第二个元素为动物的编号，整数代表狗，负数代表猫
 * ；若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1 ，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。
 * 若出现不合法的操作，即没有可以符合领养要求的动物， 则将这次领养操作忽略。 测试样例： [[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 * 
 * @author founder
 * 
 */

public class CatDogAsylum {
	private Deque<Integer> queue = new ArrayDeque<Integer>(); // 队列存储猫狗元素
	private Stack<Integer> temp = new Stack<Integer>(); // 辅助栈

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
