package dynamicprogram;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。现在一个马戏团要表演这个节目，
 * 为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。
 * 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
 * 测试样例： [[1,2],[3,4],[5,6],[7,8]],4 返回：4
 * 
 * @author founder
 * 
 */

public class GetHeight2 {
	public int getHeight(int[][] actors, int n) {
		// write code here
		int[] dp = new int[n];
		sort(actors);
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (compare(actors[i], actors[j]) && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = 1;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;

	}

	public void sort(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j][0] < arr[index][0]) {
					index = j;

				}
			}
			if (index != i) {
				int[] temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}

	public boolean compare(int[] a1, int[] a2) {
		return (a1[0] > a2[0]) && (a1[1] > a2[1]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
