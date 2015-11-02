package dynamicprogram;

import java.util.Arrays;

/**
 * 题目描述
 * 
 * 有一个单词清单，请设计一个高效算法，计算由清单中单词组成的最大子矩阵，要求矩阵中的行和列都是清单中的单词。
 * 给定一个string数组dic，代表单词清单，同时给定清单的大小n
 * ，请返回最大子矩阵的面积。保证单词清单的大小小于等于50，且某一长度的串的数量小于等于12。 测试样例：
 * ["aaa","aaa","aaa","bb","bb"] 返回：9
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