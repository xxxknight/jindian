package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * ��һ��XxY������һ��������ֻ���߸����ֻ�����һ������ߣ�Ҫ�����Ͻ��ߵ����½ǡ������һ���㷨������������ж������߷���
 * ע����ε���������Щ�ϰ����ǲ����ߵġ� ����һ��int[][] map(C++ ��Ϊvector
 * >),��ʾ����ͼ����map[i][j]Ϊ1��˵���õ㲻���ϰ��㣬������Ϊ�ϰ����������int x,int
 * y����ʾ����Ĵ�С���뷵�ػ����˴�(0,0)�ߵ�(x - 1,y - 1)���߷�����Ϊ�˷�ֹ������뽫���Mod
 * 1000000007����֤x��y��С�ڵ���50
 * 
 * @author founder
 * 
 */

//��̬�滮
public class Robot2 {
	public int countWays(int[][] map, int x, int y) {
		// write code here
		if (x <= 0 || y <= 0) {
			return -1;
		}
		int[][] dp = new int[x][y];
		if (map[0][0] != 1 || map[x - 1][y - 1] != 1) {
			return 0;
		}
		dp[0][0] = 1;

		for (int i = 1; i < y; i++) {
			if (map[0][i] != 1) {
				for (int j = i; j < y; j++) {
					dp[0][j] = 0;
				}
				break;
			} else {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < x; i++) {
			if (map[i][0] != 1) {
				for (int j = i; j < x; j++) {
					dp[j][0] = 0;
				}
				break;
			} else {
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				if (map[i][j] != 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

		}
		return dp[x - 1][y - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
