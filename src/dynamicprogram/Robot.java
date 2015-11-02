package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * ��һ��XxY������һ��������ֻ���߸����ֻ�����һ������ߣ�Ҫ�����Ͻ��ߵ����½ǡ� �����һ���㷨������������ж������߷��� ��������������int
 * x,int y���뷵�ػ����˵��߷���Ŀ����֤x��yС�ڵ���12�� ���������� 2,2 ���أ�2
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