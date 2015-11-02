package dynamicprogram;

/**
 * ��Ŀ����
 * 
 * ��һ����������ÿ����Ԫ(����)�Ǻڼ���(��0��1)�������һ����Ч�㷨���ҵ���������ɫ��ͬ������ӷ���
 * ����һ��01����mat��ͬʱ��������ı߳�n���뷵������ӷ���ı߳�����֤����߳�С�ڵ���100�� ����������
 * [[1,1,1],[1,0,1],[1,1,1]],3 ���أ�3
 * 
 * @author founder
 * 
 */

public class SubMatrix2 {
	public int maxSubMatrix(int[][] a, int n) {
		// write code here
		int r = 0;
		for (int len = 0; len <= n; len++) {
			for (int row = 0; row < n; row++) {
				if (row + len > n)
					break;
				for (int col = 0; col < n; col++) {
					if (col + len > n)
						break;
					int point = a[row][col];
					int i = 0;
					for (; i < len; i++) {
						if (a[row][col + i] != point)
							break;
						if (a[row + i][col] != point)
							break;
						if (a[row + len - 1][col + i] != point)
							break;
						if (a[row + i][col + len - 1] != point)
							break;
					}
					if (len > r && i == len)
						r = len;
				}
			}
		}
		return r;
	}
}