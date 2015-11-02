package dynamicprogram;

import java.util.Arrays;

/**
 * ��Ŀ����
 * 
 * ��һ�������嵥�������һ����Ч�㷨���������嵥�е�����ɵ�����Ӿ���Ҫ������е��к��ж����嵥�еĵ��ʡ�
 * ����һ��string����dic���������嵥��ͬʱ�����嵥�Ĵ�Сn
 * ���뷵������Ӿ�����������֤�����嵥�Ĵ�СС�ڵ���50����ĳһ���ȵĴ�������С�ڵ���12�� ����������
 * ["aaa","aaa","aaa","bb","bb"] ���أ�9
 */

public class AlphaMatrix {
	public int findAlphaMatrix(String[] dic, int n) {
		// write code here
		Arrays.sort(dic);
		if (null == dic) {
			return 0;
		}
		String temp = dic[0];
		int res = dic[0].length();
		int sum = dic[0].length();
		for (int i = 1; i < n; i++) {
			if (temp.equals(dic[i])) {
				sum += dic[i].length();
			} else {
				temp = dic[i];
				sum = dic[i].length();
			}
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new AlphaMatrix().findAlphaMatrix((new String[] {
				"aaa", "aaa", "bb", "bb", "aaa" }), 5));
	}
}