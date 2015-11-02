package divideandconquer;

import javax.xml.crypto.Data;

/**
 * 题目描述
 * 
 * 有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。 请设计一个高效的算法，计算给定数组中的逆序对个数。
 * 给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。 测试样例： [1,2,3,4,5,6,7,0],8 返回：7
 * 
 * @author founder
 * 
 */

public class AntiOrder {
	public int count(int[] A, int n) {
		// write code here
		if (A == null || n <= 1) {
			return 0;
		}
		int[] copy = new int[n];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = A[i];
		}
		int count = helper(A, copy, 0, n - 1);
		return count;
	}

	private int helper(int[] A, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = A[start];
			return 0;
		}                    

		int length = (end - start) / 2;
		int left = helper(copy, A, start, start + length);
		int right = helper(copy, A, start + length + 1, end);

		int i = start + length;
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + length + 1) {
			if (A[i] > A[j]) {
				copy[indexCopy--] = A[i--];
				count += j - start - length;
			} else {
				copy[indexCopy--] = A[j--];
			}
		}
		for (; i >= start; i--) {
			copy[indexCopy--] = A[i];
		}
		for (; j >= start + length + 1; j--) {
			copy[indexCopy--] = A[j];
		}
		return left + right + count;
	}

	public static void main(String[] args) {
		System.out.println(new AntiOrder().count(new int[] { 1, 2, 3, 4, 5, 6,
				7, 0 }, 8));
	}

}
