package twopointer;

import java.util.Arrays;

import javax.security.auth.kerberos.KerberosKey;

/**
 * 题目描述
 * 
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 * 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。 测试样例：
 * [1,2,3,4,5],5,6 返回：2
 * 
 * @author founder
 * 
 */

public class FindPair {
	public int countPairs(int[] A, int n, int sum) {
		// write code here
		if (null == A || A.length <= 1) {
			return 0;
		}
		Arrays.sort(A);
		int low = 0;
		int high = A.length - 1;
		int count = 0;
		while (low < high) {
			if (A[low] + A[high] == sum) {
				if (A[low] == A[high]) {
					int temp1 = high - low + 1;
					count += temp1 * (temp1 - 1) / 2;
					break;
				} else {
					int temp2 = low + 1;
					while (temp2 < high && A[low] == A[temp2]) {
						temp2++;
					}
					int temp3 = high - 1;
					while (temp3 > low && A[high] == A[temp3]) {
						temp3--;
					}
					count += (temp2 - low) * (high - temp3);
					low = temp2;
					high = temp3;
				}
			} else if (A[low] + A[high] < sum) {
				low++;
			} else {
				high--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new FindPair().countPairs(new int[] { 11, 7, 7, 6,
				14, 2, 14, 15, 2, 1, 2, 12, 13, 9, 8, 15, 13, 8, 10, 11, 14,
				10, 2, 9, 4, 9, 3, 7, 6, 10, 15, 4, 7, 6, 15, 3, 9, 13, 5, 2,
				6, 10, 10, 1, 12, 4, 3, 3, 8, 8, 1, 4, 7, 11, 13, 5, 13, 15, 4,
				3, 1, 11, 6, 11, 9, 9, 11, 15, 12, 10, 13, 3, 11, 4, 8, 9, 7,
				3, 13, 9, 11, 3, 2, 11, 10, 1, 4, 2, 3, 3, 14, 11, 5, 10, 1,
				14, 8, 1, 11, 3, 1, 9, 14, 6, 1, 7, 15, 10, 14, 6, 4, 12, 11 },
				113, 16));
	}

}