package heap;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����������һ��int���飬�����ҳ�������ÿ��Ԫ�ص���һ���������Ԫ�ء�
 * ����һ��int����A������Ĵ�Сn���뷵��һ��int���飬����ÿ��Ԫ�ر��������һ��Ԫ��,����������Ϊ-1�� ��֤������Ԫ�ؾ�Ϊ�������� ����������
 * [11,13,10,5,12,21,3],7 ���أ�[13,21,12,12,21,-1,-1]
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
