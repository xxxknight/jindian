package bit;

/**
 * ��Ŀ����
 * 
 * ��дһ��������ȷ����Ҫ�ı伸��λ�����ܽ�����Aת�������B�� ������������int A��int B���뷵����Ҫ�ı����λ������ ���������� 10,5
 * ���أ�4
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
