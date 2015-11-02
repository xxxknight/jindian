package dynamicprogram;

import java.util.Arrays;

/**
 * 求字符串最长递增子序列
 * 
 * [1,6,2,5,3,4],6 返回：4
 * 
 * @author founder
 * 
 */

public class GetHeight {
	public int getHeight(int[] men, int n) {
		// write code here
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <=i; j++) {
				if (men[i] > men[j] && dp[i] < dp[j]+1) {
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

	public static void main(String[] args) {

	}

}
