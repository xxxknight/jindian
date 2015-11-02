package array;

import javax.sound.midi.MidiChannel;

/**
 * ��Ŀ����
 * 
 * ��һ���Ź�������飬����n����������������������������һ�����ȵ���λ�����磬ԭ����Ϊ[1,2,3,4,5,6]��������λ5��λ�ü������[6,1,2,3
 * ,4,5],���ڶ�����λ������飬��Ҫ����ĳ��Ԫ�ص�λ�á������һ�����Ӷ�Ϊlog������㷨����������
 * ����һ��int����A��Ϊ��λ������飬ͬʱ���������Сn����Ҫ���ҵ�Ԫ�ص�ֵx���뷵��x��λ��(λ�ô��㿪ʼ)����֤������Ԫ�ػ��졣 ����������
 * [6,1,2,3,4,5],6,6 ���أ�0
 * 
 * @author founder
 * 
 */
public class Finder {
	public int findElement(int[] A, int n, int x) {
		// write code here
		if (A == null || A.length <= 0) {
			return -1;
		}
		int low = 0;
		int high = n - 1;
		int mid = 0;
		if (x == A[low]) {
			return low;
		}
		if (x == A[high]) {
			return high;
		}
		while (low + 1 < high) {
			mid = low + (high - low) / 2;
			if (x == A[mid]) {
				return mid;
			}
			if (A[low] < A[mid]) {
				if (x >= A[low] && x <= A[mid]) {
					high = mid;
				} else {
					low = mid;
				}
			} else {
				if (x >= A[mid] && x <= A[high]) {
					low = mid;
				} else {
					high = mid;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}
}
