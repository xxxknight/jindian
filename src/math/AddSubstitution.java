package math;

/**
 * 题目描述
 * 
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。 给定两个正整数int a,int b,同时给定一个int
 * type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。 测试样例：
 * 1,2,1 返回：2
 * 
 * @author founder
 * 
 */
public class AddSubstitution {
	public int calc(int a, int b, int type) {
		if (type == 1 || type == 0 || type == -1) {
			switch (type) {
			case 1: {
				return multiply(a, b);
			}
			case -1: {
				return minus(a, b);
			}
			case 0: {
				return divide(a, b);
			}
			default:
				return -1;
			}
		} else {
			throw new RuntimeException();
		}
	}

	public int multiply(int a, int b) {
		if (a == 0 || b == 0)// 与0相乘，返回0
			return 0;
		// 将问题转换成b个a相加
		if (Math.abs(a) < Math.abs(b)) {// b取绝对值的较小者，可以加速运算
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum = 0;
		for (int i = 1; i <= Math.abs(b); i++) {
			sum += a;
		}
		// 确定返回值的符号
		return b > 0 ? sum : (~sum) + 1;
	}

	public int minus(int a, int b) {
		// a-b转化成a+[-b]补，而[b]补与[-b]补之间的转换关系：连同符号位一起按位取反，再加1。
		int rb = (~b) + 1;
		return a + rb;
	}

	public int divide(int a, int b) {
		if (b == 0)
			throw new RuntimeException("b cannot be 0");
		// 问题转化成b*x = a
		int sum = 0, count = 0;
		while (sum < Math.abs(a)) {
			sum += Math.abs(b);
			count++;
		}
		sum = sum > Math.abs(a) ? --count : count;
		// 若a、b同号则返回正数
		return ((a >> 31) ^ (b >> 31)) == 0 ? count : (~count) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new AddSubstitution().calc(6, 3, -1));

	}

}
