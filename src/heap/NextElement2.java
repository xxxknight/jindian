package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目描述
 * 
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 * 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。 测试样例：
 * [11,13,10,5,12,21,3],7 [12,21,12,12,21,-1,-1]
 * 
 * @author founder
 * 
 */

public class NextElement2 {
	public int[] findNext(int[] A, int n) {
		// write code here
		if (n <= 0 || A == null) {
			return null;
		}
		int[] res = new int[n];
		List<Integer> assist = new ArrayList<Integer>();
		assist.add(A[n - 1]);
		Arrays.fill(res, -1);
		for (int i = n - 2; i >= 0; i--) {
			res[i] = getMin(assist, A[i]);
			assist.add(A[i]);
			Collections.sort(assist);
		}
		return res;
	}

	public int getMin(List<Integer> list, int val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > val) {
				return list.get(i);
			}
		}
		return -1;
	}

	public int[] findNext2(int[] A, int n) {
		// write code here
		if (n <= 0 || A == null) {
			return null;
		}
		int[] res = new int[n];
		Arrays.fill(res, -1);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (A[j] > A[i]) {
					if (res[i] == -1) {
						res[i] = A[j];
					} else {
						res[i] = Math.min(A[j], res[i]);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new NextElement2().findNext2(new int[] { 11, 13, 10, 5, 12,
				21, 3 }, 7);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
