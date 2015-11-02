package string;

/**
 * 题目描述
 * 
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 * 给定一个string stringA和一个string
 * stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。 测试样例：
 * "This is nowcoder","is This nowcoder" 返回：true "Here you are","Are you here"
 * 返回：false
 * 
 * @author founder
 * 
 */

public class Same {
	public boolean checkSam(String stringA, String stringB) {
		// write code here
		int lenA = stringA.length();
		int lenB = stringB.length();
		if (lenA != lenB) {
			return false;
		}
		int[] res = new int[256];
		for (int i = 0; i < lenA; i++) {
			res[stringA.charAt(i)]++;
			res[stringB.charAt(i)]--;
		}
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Same().checkSam("tt", "aa"));
	}

}
