package math;

/**
 * ��Ŀ����
 * 
 * ���дһ���������ҳ����������������Ǹ��������ǲ���ʹ��if-else�ȱȽϺ��ж�������� ��������int
 * a��b���뷵�ؽϴ��һ��������������ͬ�򷵻�����һ���� ���������� 1��2 ���أ�2
 * 
 * @author founder
 * 
 */
public class Max {

	public int getMax(int a, int b) {
		int diff = a - b;
		diff = (diff >> 31) & 1;
		return a - diff * b;
	}

	public int getMax2(int a, int b) {

		return (a + b + Math.abs(a - b)) / 2;
	}

}
