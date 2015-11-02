package math;

/**
 * 题目描述
 * 
 * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。 如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
 * 给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。 测试样例： 0.625 返回：0.101
 * 
 * @author founder
 * 
 */

public class BinDecimal {
	public String printBin(double num) {
		// write code here
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		double base = 0.5;
		while (num > 0) {
			if (num >= base) {
				sb.append("1");
				num -= base;
			} else {
				sb.append("0");
			}
			if (sb.length() > 32) {
				return "Error";
			}
			base /= 2;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new BinDecimal().printBin(0.625));
	}
}