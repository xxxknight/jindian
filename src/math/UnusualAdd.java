package math;

/**
 * ��Ŀ����
 * 
 * ���дһ��������������������ӡ�����ʹ��+����������������� ��������int A��B���뷵��A��B��ֵ ���������� 1,2 ���أ�3
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
