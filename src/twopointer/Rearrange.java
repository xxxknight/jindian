package twopointer;

import java.util.Arrays;

/**
 * ��Ŀ����
 * 
 * ��һ���������飬���дһ���������ҳ�����m��n��ֻҪ��m��n֮���Ԫ���ź������������������ġ�ע�⣺n-mӦ��ԽСԽ�ã�Ҳ����˵��
 * �ҳ�����������������С�
 * ����һ��int����A������Ĵ�Сn���뷵��һ����Ԫ�飬�����������е������յ㡣(ԭ����λ�ô�0��ʼ���,��ԭ�������򣬷���[0,
 * 0])����֤A��Ԫ�ؾ�Ϊ�������� ���������� [1,4,6,5,9,10],6 ���أ�[2,3]
 * 
 * @author founder
 * 
 */

public class Rearrange {
	public int[] findSegment(int[] A, int n) {
		// write code here
		int max = A[0];
		int N = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= max) {
				max = A[i];
			} else {
				N = i;
			}
		}

		int min = A[n - 1];
		int M = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (A[i] <= min) {
				min = A[i];
			} else {
				M = i;
			}
		}
		return new int[] { M, N };

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Rearrange().findSegment(
				new int[] {1,4,6,5,9,10}, 6)));

	}
}