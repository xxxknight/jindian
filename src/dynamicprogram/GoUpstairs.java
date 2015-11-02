package dynamicprogram;

/**
 * 题目描述
 * 
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。 为了防止溢出，请将结果Mod
 * 1000000007 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。 测试样例： 1 返回：1
 * 
 * @author founder
 * 
 */

public class GoUpstairs {
	public int countWays(int n) {
		// write code here
		if (n <= 0) {
			return 0;
		}
		int res = 0;
		int r1 = 1;
		int r2 = 2;
		int r3 = 4;
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		for (int i = 4; i <= n; i++) {
			res = (((r1 + r2) % 1000000007) + r3) % 1000000007;
			r1 = r2;
			r2 = r3;
			r3 = res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new GoUpstairs().countWays(4));
	}
}
