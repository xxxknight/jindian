package math;

/**
 * 题目描述
 * 
 * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，使得一次操作无法取得数组number里某个整数的完整内容。
 * 唯一的可用操作是询问数组中第i个元素的二进制的第j位(最低位为第0位)，该操作的时间复杂度为常数，请设计算法，在O(n)的时间内找到这个数。
 * 给定一个数组number，即所有剩下的数按从小到大排列的二进制各位的值，如A[0][1]表示剩下的第二个数二进制从低到高的第二位。同时给定一个int
 * n，意义如题。请返回缺失的数。 测试样例： [[0],[0,1]] 返回：1
 * 
 * @author founder
 * 
 */

/**
 * [0] => 0 [1] => 1 [0,1] => 2 [1,1] => 3 [0,0,1] => 4 [0,1,1] => 6 ...
 * 可以看出每一行的第一位在缺失数之前是按照0，1交替出现的。缺失数即在不符合规律的地方出现
 * 
 * 
 */
public class Finder {
	public int findMissing(int[][] numbers, int n) {
		// write code here
		if (n <= 0) {
			return 0;
		}
		for (int i = 0; i < n; i++) {
			if (i % 2 != numbers[i][0]) {
				return i;
			}
		}
		return n;
	}

	public static void main(String[] args) {

	}
}