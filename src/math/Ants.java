package math;

/**
 * ��Ŀ����
 * 
 * ��n������Ķ��������nֻ���ϣ���Щ����ͬʱ��ʼ���Ŷ���εı����У��������Щ������ײ�ĸ��ʡ� (�������ײ��ָ����������ֻ���ϻ���ײ) ����һ��int
 * n(3<=n<=10000)������n���κ�nֻ���ϣ��뷵��һ��double��Ϊ��ײ�ĸ��ʡ� ���������� 3 ���أ�0.75
 * 
 * @author founder
 * 
 */

public class Ants {
	public double antsCollision(int n) {
		// write code here

		return n <= 0 ? 0 : 1 - Math.pow(2, 1 - n);
	}
}