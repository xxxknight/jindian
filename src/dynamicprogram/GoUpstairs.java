package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * �и�С��������¥�ݣ�¥����n��̨�ף�С��һ�ο�����1�ס�2�ס�3�ס���ʵ��һ������������С���ж�������¥�ķ�ʽ�� Ϊ�˷�ֹ������뽫���Mod
 * 1000000007 ����һ��������int n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100000�� ���������� 1 ���أ�1
 * 
 * @author founder
 * 
 */

public class GoUpstairs {
	public int countWays(int n) {
		// write code here
		if (n <= 0) {
			return 0;
		}
		int res = 0;
		int r1 = 1;
		int r2 = 2;
		int r3 = 4;
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		for (int i = 4; i <= n; i++) {
			res = (((r1 + r2) % 1000000007) + r3) % 1000000007;
			r1 = r2;
			r2 = r3;
			r3 = res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new GoUpstairs().countWays(4));
	}
}
