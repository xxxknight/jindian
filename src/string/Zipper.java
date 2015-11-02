package string;

/**
 * ��Ŀ����
 * 
 * �����ַ��ظ����ֵĴ�������дһ��������ʵ�ֻ������ַ���ѹ�����ܡ����磬�ַ�����aabcccccaaa����ѹ�����ɡ�a2b1c5a3����
 * ��ѹ������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ����� ����һ��string
 * iniStringΪ��ѹ���Ĵ�(����С�ڵ���3000)����֤�����ַ����ɴ�СдӢ����ĸ��ɣ�����һ��string��Ϊ�����ѹ�����δ�仯�Ĵ��� ��������
 * "aabcccccaaa" ���أ�"a2b1c5a3" "welcometonowcoderrrrr"
 * ���أ�"welcometonowcoderrrrr"
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