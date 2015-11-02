package dynamicprogram;

/**
 * 题目描述
 * 
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。 请设计一个算法，计算机器人有多少种走法。 给定两个正整数int
 * x,int y，请返回机器人的走法数目。保证x＋y小于等于12。 测试样例： 2,2 返回：2
 * 
 * @author founder
 * 
 */

public class Robot {
	public int countWays(int x, int y) {
		// write code here
		if (x <= 0 || y <= 0) {
			return -1;
		}
		int[][] dp = new int[x][y];
		dp[0][0] = 1;
		for (int i = 1; i < y; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < x; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[x - 1][y - 1];
	}

	public static void main(String[] args) {

	}
}