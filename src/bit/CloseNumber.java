package bit;

import java.util.Arrays;

/**
 * ��Ŀ����
 * 
 * ��һ�������������ҳ�������Ʊ�ʾ��1�ĸ�����ͬ���Ҵ�С��ӽ�������������(һ���Դ�һ����С) ����������int
 * x���뷵��һ��vector�������������������С����ǰ������֤�𰸴��ڡ� ���������� 2 ���أ�[1,4]
 * 
 * @author founder
 * 
 */

public class CloseNumber {
	public int[] getCloseNumber(int x) {
		if (x <= 0) {
			return null;
		}
		int[] res = new int[2];
		res[0] = getPrev(x);
		res[1] = getNext(x);
		return res;
	}

	// �ؼ���:�ҵ�����β0������һ�����ӵ͵���λ���ұ���1��0
	private int getNext(int x) {
		if (x <= 1) {
			return -1;
		}
		int temp = x;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		return x + (1 << c0) + (1 << (c1 - 1)) - 1;
	}

	// �ؼ���:�ҵ�����β1������һ�����ӵ͵���λ���ұ���0��1
	private int getPrev(int x) {
		if (x <= 1) {
			return -1;
		}
		int temp = x;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		return x - (1 << c1) - (1 << (c0 - 1)) + 1;
	}

	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(new CloseNumber().getCloseNumber(5)));
	}
}