package binarysearch;

import javax.sound.midi.MidiChannel;

/**
 * 题目描述
 * 
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 * 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。 测试样例：
 * ["a","b","","c","","d"],6,"c" 返回：3
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
