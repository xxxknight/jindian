package dynamicprogram;

public class MaxSum {
	public int getMaxSum(int[] A, int n) {
		// write code here
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSum().getMaxSum(new int[] { 1, 2, 3, -6, 1 },
				5));
	}

}
