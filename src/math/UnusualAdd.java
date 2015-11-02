package math;

/**
 * 题目描述
 * 
 * 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。 给定两个int A和B。请返回A＋B的值 测试样例： 1,2 返回：3
 * 
 * @author founder
 * 
 */

public class UnusualAdd {
	public int addAB(int A, int B) {
		int sum = 0;
		int carry = 0;
		do {
			sum = A ^ B;
			carry = (A & B) << 1;
			A = sum;
			B = carry;
		} while (B != 0);
		// write code here
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UnusualAdd().addAB(2, 4));

	}

}
