package math;

public class Factor {
	public int getFactorSuffixZero(int n) {
		int x = 5;
		int count = 0;
		while (n >= x) {
			count += n / x;
			x *= 5;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Factor().getFactorSuffixZero(10));
	}

}
