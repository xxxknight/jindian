package heap;

import java.util.Arrays;
import java.util.Stack;

/**
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
 * 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。 保证数组中元素均为正整数。 测试样例：
 * [11,13,10,5,12,21,3],7 返回：[13,21,12,12,21,-1,-1]
 * 
 * @author founder
 * 
 */
public class NextElement {
	public int[] findNext(int[] A, int n) {
		// write code here
		if (n <= 0 || A == null) {
			return null;
		}
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(A[A.length - 1]);
		for (int i = res.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() != -1
					&& A[i] > stack.peek()) {
				stack.pop();
			}
			res[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(A[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new NextElement().findNext(new int[] { 11, 13, 10, 5, 12,
				21, 3 }, 7);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
