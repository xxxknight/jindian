package math;

/**
 * ��Ŀ����
 * 
 * ���дһ��������ʵ�������ĳ˷��������ͳ�������(����ĳ�ָ����)��ֻ����ʹ�üӺš� ��������������int a,int b,ͬʱ����һ��int
 * type������������ͣ�1Ϊ��a �� b��0Ϊ��a �� b��-1Ϊ��a �� b���뷵�ؼ���Ľ������֤���ݺϷ��ҽ��һ����int��Χ�ڡ� ����������
 * 1,2,1 ���أ�2
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
		if (a == 0 || b == 0)// ��0��ˣ�����0
			return 0;
		// ������ת����b��a���
		if (Math.abs(a) < Math.abs(b)) {// bȡ����ֵ�Ľ�С�ߣ����Լ�������
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum = 0;
		for (int i = 1; i <= Math.abs(b); i++) {
			sum += a;
		}
		// ȷ������ֵ�ķ���
		return b > 0 ? sum : (~sum) + 1;
	}

	public int minus(int a, int b) {
		// a-bת����a+[-b]������[b]����[-b]��֮���ת����ϵ����ͬ����λһ��λȡ�����ټ�1��
		int rb = (~b) + 1;
		return a + rb;
	}

	public int divide(int a, int b) {
		if (b == 0)
			throw new RuntimeException("b cannot be 0");
		// ����ת����b*x = a
		int sum = 0, count = 0;
		while (sum < Math.abs(a)) {
			sum += Math.abs(b);
			count++;
		}
		sum = sum > Math.abs(a) ? --count : count;
		// ��a��bͬ���򷵻�����
		return ((a >> 31) ^ (b >> 31)) == 0 ? count : (~count) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new AddSubstitution().calc(6, 3, -1));

	}

}
