package dynamicprogram;

/**
 * 题目描述
 * 
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，
 * 在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。请返回洪水流到( n - 1,m -
 * 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
 *  给定一个矩阵map表示城市，其中map[i
 * ][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
 *  同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n -
 * 1,m - 1)的最早时间。保证洪水一定能流到终点。
 * 
 * @author founder
 * 
 */

public class Flood {
	public int floodFill(int[][] map, int n, int m) {
		// write code here
		// write code here
		int[][] dp = new int[n][m];
		dp[0][0] = 0; // 开始点为0，不需要时间
		// deal with the first row
		for (int i = 1; i < m; i++) {
			if (map[0][i] == 1) // 有障碍，设置成最大值
				dp[0][i] = 1000;
			else
				dp[0][i] = dp[0][i - 1] + 1;
		}
		// deal with the first col
		for (int i = 1; i < n; i++) {
			if (map[i][0] == 1)
				dp[i][0] = 1000;
			else
				dp[i][0] = dp[i - 1][0] + 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (map[i][j] == 1)
					dp[i][j] = 1000;
				else
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {

	}
}