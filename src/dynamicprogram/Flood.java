package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * ��һ��nxm������״�ĳ����ﱬ���˺�ˮ����ˮ��(0,0)�ĸ�������������У�
 * ������������еĸ�����һЩ��������ˮֻ����û�н����ĸ����������뷵�غ�ˮ����( n - 1,m -
 * 1)������ʱ��(��ˮֻ�ܴ�һ���������������ڵĸ����Һ�ˮ��λʱ���ܴ�һ�������������ڸ���)��
 *  ����һ������map��ʾ���У�����map[i
 * ][j]��ʾ����Ϊ(i,j)�ĸ��ӣ�ֵΪ1����ø����н�����0����û�н�����
 *  ͬʱ��������Ĵ�Сn��m(n��m��С�ڵ���100)���뷵������(n -
 * 1,m - 1)������ʱ�䡣��֤��ˮһ���������յ㡣
 * 
 * @author founder
 * 
 */

public class Flood {
	public int floodFill(int[][] map, int n, int m) {
		// write code here
		// write code here
		int[][] dp = new int[n][m];
		dp[0][0] = 0; // ��ʼ��Ϊ0������Ҫʱ��
		// deal with the first row
		for (int i = 1; i < m; i++) {
			if (map[0][i] == 1) // ���ϰ������ó����ֵ
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