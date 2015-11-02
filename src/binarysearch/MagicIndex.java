package binarysearch;

/**
 * 题目描述 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。
 * 给定一个不下降序列，元素值可能相同，编写一个方法，判断在数组A中是否存在魔术索引。 请思考一种复杂度优于o(n)的方法。 给定一个int数组A和int
 * n代表数组大小，请返回一个bool，代表是否存在魔术索引。 测试样例： [1,1,3,4,5] 返回：true
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