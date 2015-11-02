package array;

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

public class SubMatrix {
	public int maxSubMatrix(int[][] mat, int n) {
		// write code here
		if (null == mat || 0 == mat.length) {
			return 0;
		}
		int len = mat.length;
		int x = 0;
		int y = 0;
		while (len > 0) {
			if (len == 1) {
				if (mat[x][y] == 1) {
					return 1;
				}
			}
			if (helper(mat, len, x, y)) {
				return len;
			}

			x++;
			y++;
			len -= 2;
		}
		return 0;
	}

	private boolean helper(int[][] mat, int len, int x, int y) {
		for (int i = 0; i < len - 1; i++) {
			if (mat[x][y + i] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + i][y + len - 1] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + len - 1][y + len - 1 - i] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + len - 1 - i][y] == 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] res = {{1,1,1,0,0},{1,1,1,0,1},{0,0,0,0,0},{1,0,1,1,0},{1,0,0,0,1}};
		System.out.println(new SubMatrix().maxSubMatrix(res, 5));
	}
}