package bit;

import java.util.Arrays;

/**
 * 题目描述
 * 
 * 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小) 给定正整数int
 * x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。 测试样例： 2 返回：[1,4]
 * 
 * @author founder
 * 
 */

public class CloseNumber {
	public int[] getCloseNumber(int x) {
		if (x <= 0) {
			return null;
		}
		int[] res = new int[2];
		res[0] = getPrev(x);
		res[1] = getNext(x);
		return res;
	}

	// 关键点:找到非拖尾0，即第一个（从低到高位）右边有1的0
	private int getNext(int x) {
		if (x <= 1) {
			return -1;
		}
		int temp = x;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		return x + (1 << c0) + (1 << (c1 - 1)) - 1;
	}

	// 关键点:找到非拖尾1，即第一个（从低到高位）右边有0的1
	private int getPrev(int x) {
		if (x <= 1) {
			return -1;
		}
		int temp = x;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		return x - (1 << c1) - (1 << (c0 - 1)) + 1;
	}

	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(new CloseNumber().getCloseNumber(5)));
	}
}