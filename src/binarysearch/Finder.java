package binarysearch;

/**
 * ��Ŀ����
 * 
 * ��һ��NxM���������󣬾�����к��ж��Ǵ�С��������ġ������һ����Ч�Ĳ����㷨�����Ҿ�����Ԫ��x��λ�á�
 * ����һ��int�������mat��ͬʱ��������Ĵ�Сn��m�Լ���Ҫ���ҵ�Ԫ��x���뷵��һ����Ԫ���飬�����Ԫ�ص��кź��к�(�����㿪ʼ)�� ��֤Ԫ�ػ��졣
 * ���������� [[1,2,3],[4,5,6]],2,3,6 ���أ�[1,2]
 * 
 * @author founder
 * 
 */

public class Finder {

	public int[] findElement(int[][] mat, int n, int m, int x) {
		if (mat == null || mat[0] == null) {
			return null;
		}
		int i = 0;
		int j = m - 1;
		while (i < n && j >= 0) {
			int temp = mat[i][j];
			if (x > temp) {
				i++;
			} else if (x < temp) {
				j--;
			} else {
				return new int[] { i, j };
			}
		}
		return new int[] {};

	}

	public static void main(String[] args) {
		System.out.println(new Finder().findElement(new int[][] { { 1, 2, 3 },
				{ 4, 5, 6 } }, 2, 3, 6));
	}
}
