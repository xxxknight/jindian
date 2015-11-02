package bit;

/**
 * 题目描述
 * 
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。 给定两个整数int A，int B。请返回需要改变的数位个数。 测试样例： 10,5
 * 返回：4
 * 
 * @author founder
 * 
 */

public class Transform {
	public int calcCost(int A, int B) {
		// write code here
		int res = A ^ B;
		return countOneBit(res);
	}

	public int countOneBit(int num) {
		int count = 0;
		while (num != 0) {
			num &=(num-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Transform().calcCost(10, 5));
	}
}
