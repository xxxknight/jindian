package dynamicprogram;

/**
 * 题目描述
 * 
 * 有一个正整数和负整数组成的NxN矩阵，请编写代码找出元素总和最大的子矩阵。请尝试使用一个高效算法。
 * 给定一个int矩阵mat和矩阵的阶数n，请返回元素总和最大的子矩阵的元素之和。 保证元素绝对值小于等于100000，且矩阵阶数小于等于200。 测试样例：
 * [[1,2,-3],[3,4,-5],[-5,-6,-7]],3 返回：10
 * 
 * @author founder
 * 
 */

public class SubMatrix {
	public int sumOfSubMatrix(int[][] mat, int n) {
		// write code here
		if (null == mat || mat.length == 0 || n == 0) {
			return -1;
		}
		int col = mat[0].length;
		int[] dp = new int[col];
		int sum = 0; // 记录每行中出现的和
		int max = 0; // 记录最大值
		// x:为行标号
		for (int x = 0; x < n; x++) {
			dp[0] = mat[x][0];
			sum = Math.max(0, dp[0]);
			max = Math.max(max, sum);
			// y:为标号
			for (int y = 1; y < col; y++) {
				dp[y] = mat[x][y];
				sum = Math.max(0, sum + dp[y]);
				max = Math.max(max, sum);
			}
			for (int i = x + 1; i < n; i++) {
				dp[0] += mat[i][0];
				sum = Math.max(0, dp[0]);
				max = Math.max(max, sum);
				for (int y = 1; y < col; y++) {
					dp[y] += mat[i][y];
					sum = Math.max(0, sum + dp[y]);
					max = Math.max(max, sum);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1 }, { 2, -1 } };
		System.out.println(new SubMatrix().sumOfSubMatrix(mat, 2));
	}
}