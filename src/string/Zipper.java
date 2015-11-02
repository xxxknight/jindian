package string;

/**
 * 题目描述
 * 
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 * 若压缩后的字符串没有变短，则返回原先的字符串。 给定一个string
 * iniString为待压缩的串(长度小于等于3000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。 测试样例
 * "aabcccccaaa" 返回："a2b1c5a3" "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 * 
 * @author founder
 * 
 */

public class Zipper {
	public String zipString(String iniString) {

		if (null == iniString || "".equals(iniString) || iniString.isEmpty()) {
			return "";
		}
		int len = iniString.length();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		int i = 0;
		while (i < len - 1) {
			if (iniString.charAt(i + 1) == iniString.charAt(i)) {
				count++;
			} else {
				sb.append(iniString.charAt(i)).append(count);
				count = 1;
			}

			i++;
		}
		sb.append(iniString.charAt(i)).append(count);
		return sb.length() > len ? iniString : sb.toString();
		// write code here
	}

	public static void main(String[] args) {
		System.out.println(new Zipper().zipString("aabcccccaaa"));
	}
}