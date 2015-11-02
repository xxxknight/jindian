package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目描述
 * 
 * 编写一个方法，确定某字符串的所有排列组合。 给定一个string A和一个int
 * n,代表字符串和其长度，请返回所有该字符串字符的排列，保证字符串长度小于等于11且字符串中字符均为大写英文字符
 * ，排列中的字符串按字典序从大到小排序。(不合并重复字符串) 测试样例： "ABC"
 * 返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 * 
 * @author founder
 * 
 */

public class Permutation {
	private ArrayList<String> res = new ArrayList<String>();

	public ArrayList<String> getPermutation(String A) {
		// write code here
		if (null == A || A.isEmpty()) {
			return res;
		}
		char[] arr = A.toCharArray();
		helper(arr, 0, arr.length - 1);
		Collections.sort(res, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		return res;
	}

	public void helper(char[] arr, int start, int end) {
		if (start == end) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			if (sb.length() > 0) {
				res.add(sb.toString());
			}
		}
		for (int i = start; i <= end; i++) {
			char temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			helper(arr, start + 1, end);
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
		}

	}

	public static void main(String[] args) {
		System.out.println(new Permutation().getPermutation("ABC"));
	}
}