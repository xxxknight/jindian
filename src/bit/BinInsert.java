package bit;

/**
 * ��Ŀ����
 * 
 * ������32λ����n��m�����д�㷨��m�Ķ�������λ���뵽n�Ķ����Ƶĵ�j����iλ,���ж����Ƶ�λ���ӵ�λ������λ����0��ʼ�� ����������int n��int
 * m��ͬʱ����int j��int i�����������������뷵�ز������������֤n�ĵ�j����iλ��Ϊ�㣬��m�Ķ�����λ��С�ڵ���i-j+1�� ����������
 * 1024��19��2��6 ���أ�1100
 * 
 * @author founder
 * 
 */

public class BinInsert {
	public int binInsert(int n, int m, int j, int i) {
		return (m << j) | n;
	}

	public static void main(String[] args) {
		// System.out.println(Integer.toBinaryString(19));
		// System.out.println(Integer.toBinaryString(1024));
		// System.out.println(Integer.parseInt("10001001100", 2));
		System.out.println(new BinInsert().binInsert(4355, 4, 2, 7));
	}

}
