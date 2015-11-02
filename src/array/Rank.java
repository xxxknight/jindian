package array;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * ��Ŀ����
 * 
 * ��������Ҫ����һ������ͬʱҪ���ڶ���ÿ������ʱ����������ȣ����ڵ�ǰ������С�ڵ����������ĸ���(������������)��
 * �����һ����Ч�����ݽṹ���㷨��ʵ��������ܡ�
 * ����һ��int����A��ͬʱ�������Ĵ�Сn���뷵��һ��int���飬Ԫ��Ϊÿ�μ���������ȡ���֤�����СС�ڵ���5000�� ����������
 * [1,2,3,4,5,6,7],7 ���أ�[0,1,2,3,4,5,6]
 * 
 * @author founder
 * 
 */

public class Rank {
	public int[] getRankOfNumber(int[] A, int n) {
		// write code here
		if (null == A || 0 == A.length || n <= 0) {
			return null;
		}
		int[] res = new int[n];
		res[0] = 0;
		for (int i = 1; i < res.length; i++) {
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					count++;
				}
			}
			res[i] = count;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Rank().getRankOfNumber(new int[] { 1, 2, 3, 4,
				5, 6, 7 }, 7));
	}
}