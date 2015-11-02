package array;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 
 * 现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
 * 请设计一个高效的数据结构和算法来实现这个功能。
 * 给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。 测试样例：
 * [1,2,3,4,5,6,7],7 返回：[0,1,2,3,4,5,6]
 * 
 * @author founder
 * 
 */

public class Rank {
	public int[] getRankOfNumber(int[] A, int n) {
		// write code here
		if (null == A || 0 == A.length || n <= 0) {
			return null;
		}
		int[] res = new int[n];
		res[0] = 0;
		for (int i = 1; i < res.length; i++) {
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					count++;
				}
			}
			res[i] = count;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Rank().getRankOfNumber(new int[] { 1, 2, 3, 4,
				5, 6, 7 }, 7));
	}
}