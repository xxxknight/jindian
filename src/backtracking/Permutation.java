package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ��Ŀ����
 * 
 * ��дһ��������ȷ��ĳ�ַ���������������ϡ� ����һ��string A��һ��int
 * n,�����ַ������䳤�ȣ��뷵�����и��ַ����ַ������У���֤�ַ�������С�ڵ���11���ַ������ַ���Ϊ��дӢ���ַ�
 * �������е��ַ������ֵ���Ӵ�С����(���ϲ��ظ��ַ���) ���������� "ABC"
 * ���أ�["CBA","CAB","BCA","BAC","ACB","ABC"]
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