package string;

/**
 * ��Ŀ����
 * 
 * ���������ַ��������д����ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ���������涨��СдΪ��ͬ�ַ����ҿ����ַ����ص�ո�
 * ����һ��string stringA��һ��string
 * stringB���뷵��һ��bool�����������Ƿ��������к����ͬ����֤�����ĳ��ȶ�С�ڵ���5000�� ����������
 * "This is nowcoder","is This nowcoder" ���أ�true "Here you are","Are you here"
 * ���أ�false
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
