package binarysearch;

import javax.sound.midi.MidiChannel;

/**
 * ��Ŀ����
 * 
 * ��һ���Ź�����ַ������飬���������в�����һЩ���ַ����������һ���㷨���ҳ������ַ�����λ�á��㷨�Ĳ��Ҳ��ֵĸ��Ӷ�Ӧ��Ϊlog����
 * ����һ��string����str,ͬʱ���������Сn����Ҫ���ҵ�string x���뷵�ظô���λ��(λ�ô��㿪ʼ)�� ����������
 * ["a","b","","c","","d"],6,"c" ���أ�3
 * 
 * @author founder
 * 
 */
public class FindString {
	public int findString(String[] str, int n, String x) {
		// write code here
		if (null == str || str.length == 0 || n == 0) {
			return -1;
		}
		int low = 0;
		int high = str.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (str[mid].equals("")) {
				int index = mid;
				while (index >= low && str[index].equals("")) {
					index--;
				}
				if (index < low) {
					low = mid + 1;
				} else if (str[index].compareTo(x) == 0) {
					return index;
				} else if (str[index].compareTo(x) > 1) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (x.equals(str[mid])) {
					return mid;
				} else if (str[mid].compareTo(x) > 0) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
