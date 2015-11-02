package math;

/**
 * 题目描述
 * 
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。 给定一个正整数n，请返回0到n的数字中2出现了几次。 测试样例： 10 返回：1
 * 
 * @author founder
 * 
 */
public class Count2 {
	public int countNumberOf2s(int n) {
		// write code here
		if (n <= 1) {
			return 0;
		}
		int high = 0;
		int cur = 0;
		int low = 0;
		int factor = 1;
		int res = 0;
		while (n / factor > 0) {
			cur = (n / factor) % 10;
			high = n / (factor * 10);
			if (cur < 2) {
				res += high * factor;
			} else if (cur == 2) {
				res += high * factor + low + 1;
			} else {
				res += (high + 1) * factor;
			}
			low += cur * factor;
			factor *= 10;

		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(new Count2().countNumberOf2s(20));
	}
}