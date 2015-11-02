package binarysearch;

/**
 * ��Ŀ���� ������A[0..n-1]�У�����ν��ħ����������������A[i]=i��
 * ����һ�����½����У�Ԫ��ֵ������ͬ����дһ���������ж�������A���Ƿ����ħ�������� ��˼��һ�ָ��Ӷ�����o(n)�ķ����� ����һ��int����A��int
 * n���������С���뷵��һ��bool�������Ƿ����ħ�������� ���������� [1,1,3,4,5] ���أ�true
 * 
 * @author founder
 * 
 */

public class MagicIndex {
	public boolean findMagicIndex(int[] A, int n) {
		// write code here
		int low = 0;
		int high = n - 1;
		int mid = 0;
		if (A[low] == low) {
			return true;
		}
		if (A[high] == high) {
			return true;
		}
		while (low + 1 < high) {
			mid = low + (high - low) / 2;
			if (A[mid] == mid) {
				return true;
			} else if (A[mid] > mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 3, 4, 5 };
		System.out.println(new MagicIndex().findMagicIndex(A, A.length));
	}
}