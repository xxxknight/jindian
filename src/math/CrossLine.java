package math;

/**
 * ��Ŀ����
 * 
 * ����ֱ������ϵ�ϵ�����ֱ�ߣ�ȷ��������ֱ�߻᲻���ཻ�� �߶���б�ʺͽؾ����ʽ��������double s1��double s2��double
 * y1��double
 * y2���ֱ����ֱ��1��2��б��(��s1,s2)�ͽؾ�(��y1,y2)���뷵��һ��bool���������������ֱ���Ƿ��ཻ��������ֱ���غ�Ҳ��Ϊ�ཻ��
 * ���������� 3.14,3.14,1,2 ���أ�false
 * 
 * @author founder
 * 
 */

public class CrossLine {
	public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
		if (s1 == s2) {
			if (y1 == y2) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
