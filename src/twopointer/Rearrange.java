package twopointer;

import java.util.Arrays;

/**
 * 题目描述
 * 
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。注意：n-m应该越小越好，也就是说，
 * 找出符合条件的最短序列。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,
 * 0])。保证A中元素均为正整数。 测试样例： [1,4,6,5,9,10],6 返回：[2,3]
 * 
 * @author founder
 * 
 */

public class Rearrange {
	public int[] findSegment(int[] A, int n) {
		// write code here
		int max = A[0];
		int N = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= max) {
				max = A[i];
			} else {
				N = i;
			}
		}

		int min = A[n - 1];
		int M = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (A[i] <= min) {
				min = A[i];
			} else {
				M = i;
			}
		}
		return new int[] { M, N };

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Rearrange().findSegment(
				new int[] {1,4,6,5,9,10}, 6)));

	}
}