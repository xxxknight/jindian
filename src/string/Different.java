package string;

/**
 * ��Ŀ����
 * 
 * ��ʵ��һ���㷨��ȷ��һ���ַ����������ַ��Ƿ�ȫ����ͬ����������Ҫ������ʹ�ö���Ĵ洢�ṹ�� ����һ��string
 * iniString���뷵��һ��boolֵ
 * ,True���������ַ�ȫ����ͬ��False���������ͬ���ַ�����֤�ַ����е��ַ�ΪASCII�ַ����ַ����ĳ���С�ڵ���3000�� ����������
 * "aeiou" ���أ�True "BarackObama" ���أ�False
 * 
 * @author founder
 * 
 */

public class Different {
	public boolean checkDifferent(String iniString) {
		// write code here
		if (iniString.length() > 256) {
			return false;
		}
		for (int i = 0; i < iniString.length(); i++) {
			for (int j = i + 1; j < iniString.length(); j++) {
				if (iniString.charAt(i) == iniString.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
