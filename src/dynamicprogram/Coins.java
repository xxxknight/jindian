package dynamicprogram;

/**
 * 题目描述
 * 
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。 给定一个int
 * n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。 测试样例： 6 返回：2
 * 
 * @author founder
 * 
 */

public class Coins {
	public int countWays(int n) {
		// write code here
		int N_25 = n / 25;
		long total = 0;
		for (int i = 0; i <= N_25; i++) {
			long N_5 = (n - i * 25) / 5;
			if (N_5 % 2 == 0) {
				total += ((N_5 + 2) * (N_5 + 2) / 4) % 1000000007;
			} else {
				total += ((N_5 + 3) * (N_5 + 1) / 4) % 1000000007;
			}
		}
		return (int) ((total) % 1000000007);
	}

	public int countWays2(int n) {
		int[] dp = new int[n + 1];
		int[] coins = { 1, 5, 10, 25 };
		dp[0] = 1;
		for (int i = 0; i < coins.length; ++i) {
			for (int j = coins[i]; j <= n; ++j) {
				dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
				// System.out.println(j + "  " + dp[j]);
			}
		}
		for (int i = 0; i <= n; i++) {
			// System.out.println(i+"  "+dp[i]);
		}
		return dp[n];
	}

	// 类比于countWays2
	public int countWays4(int n) {
		int[] coins = { 1, 5, 10, 25 };
		int[][] dp = new int[coins.length + 1][n + 1];
		for (int i = 0; i <= coins.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; ++i) {
			for (int j = 1; j <= n; ++j) {
				for (int k = 0; k <= j / coins[i - 1]; ++k) {
					dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
				}
			}
		}
		return dp[coins.length][n];
	}

	public int countWays3(int n) {
		if (n <= 0) {
			return 0;
		}
		return helper(n, 25);
	}

	public int helper(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		long ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += helper(n - i * denom, next_denom) % 1000000007;
		}
		return (int) (ways % 1000000007);
	}

	public static void main(String[] args) {
		Coins coins = new Coins();
		// System.out.println(coins.countWays(2500));
		System.out.println(coins.countWays2(100));
		System.out.println(coins.countWays4(100));
		// System.out.println(coins.countWays3(2500));
	}
}
