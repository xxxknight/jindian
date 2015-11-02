package math;

/**
 * ��Ŀ����
 * 
 * ���дһ�����������0��n(����n)������2�����˼��Ρ� ����һ��������n���뷵��0��n��������2�����˼��Ρ� ���������� 10 ���أ�1
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