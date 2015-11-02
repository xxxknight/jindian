package sort;

import java.util.Arrays;

public class MergeSort {
	private int count = 0;

	/**
	 * �鲢���� ���:�����������������ϣ������ϲ���һ���µ������
	 * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ ʱ�临�Ӷ�ΪO(nlogn) �ȶ�����ʽ
	 * 
	 * @param nums
	 *            ����������
	 * @return �����������
	 */

	public int count(int[] A, int n) {
		// write code here
		if (A == null || n <= 1) {
			return 0;
		}
		sort(A, 0, n - 1);
		return count;
	}

	public void sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// ���
			sort(nums, low, mid);
			// �ұ�
			sort(nums, mid + 1, high);
			// ���ҹ鲢
			merge(nums, low, mid, high);
		}
	}

	public void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = mid;// ��ָ��
		int j = high;// ��ָ��
		int k = high;

		while (i >= low && j >= mid+1) {
			if (nums[i] > nums[j]) {
				temp[k--] = nums[i--];
				count += j - mid;
			} else {
				temp[k--] = nums[j--];
			}
		}
		for (; i >= low; i--) {
			temp[k--] = nums[i];
		}
		for (; j >= mid + 1; j--) {
			temp[k--] = nums[j];
		}

		// ���������е�������nums����
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

	// �鲢�����ʵ��
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		System.out.println(new MergeSort().count(nums, 10));
	}
}