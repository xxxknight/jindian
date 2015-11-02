package sort;

import java.util.Arrays;

public class MergeSort {
	private int count = 0;

	/**
	 * 归并排序 简介:将两个（或两个以上）有序表合并成一个新的有序表
	 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 时间复杂度为O(nlogn) 稳定排序方式
	 * 
	 * @param nums
	 *            待排序数组
	 * @return 输出有序数组
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
			// 左边
			sort(nums, low, mid);
			// 右边
			sort(nums, mid + 1, high);
			// 左右归并
			merge(nums, low, mid, high);
		}
	}

	public void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = mid;// 左指针
		int j = high;// 右指针
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

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

	// 归并排序的实现
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		System.out.println(new MergeSort().count(nums, 10));
	}
}