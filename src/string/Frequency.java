package string;

/**
 * ��Ŀ����
 * 
 * �����һ����Ч�ķ������ҳ�����ָ��������һƪ�����еĳ���Ƶ����
 * ����һ��string����article�������Сn��һ����ͳ�Ƶ���word���뷵�ظõ����������еĳ���Ƶ������֤���µĴ���С�ڵ���1000��
 * 
 * @author founder
 * 
 */
public class Frequency {
	public int getFrequency(String[] article, int n, String word) {
		// write code here
		int res = 0;
		for (String sen : article) {
			if (sen.equals(word)) {
				res++;
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
