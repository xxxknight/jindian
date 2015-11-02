package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * ��һ���������͸�������ɵ�NxN�������д�����ҳ�Ԫ���ܺ������Ӿ����볢��ʹ��һ����Ч�㷨��
 * ����һ��int����mat�;���Ľ���n���뷵��Ԫ���ܺ������Ӿ����Ԫ��֮�͡� ��֤Ԫ�ؾ���ֵС�ڵ���100000���Ҿ������С�ڵ���200�� ����������
 * [[1,2,-3],[3,4,-5],[-5,-6,-7]],3 ���أ�10
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
		int sum = 0; // ��¼ÿ���г��ֵĺ�
		int max = 0; // ��¼���ֵ
		// x:Ϊ�б��
		for (int x = 0; x < n; x++) {
			dp[0] = mat[x][0];
			sum = Math.max(0, dp[0]);
			max = Math.max(max, sum);
			// y:Ϊ���
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