package twopointer;

/**
 * ��Ŀ����
 * 
 * ��һƪ�����ں�������ʣ��ָ����������ʣ������һ����Ч�㷨���ҳ��������������ʵ���̾���(����������ĵ�����,Ҳ��������������������λ�õĲ�ľ���ֵ)��
 * ����һ��string����article
 * �������������£�ͬʱ�������µĵ�����n�ʹ����ҵ���������x��y���뷵���������ʵ���̾��롣��֤�������ʾ������г����Ҳ���ͬ
 * ��ͬʱ��֤���µ�����С�ڵ���1000��
 * 
 * @author founder
 * 
 */

public class Distance {
	public int getDistance(String[] article, int n, String x, String y) {
		// write code here
		int p = -1;
		int distance = 1000;
		for (int i = 0; i < article.length; i++) {
			if (x.equals(article[i]) || y.equals(article[i])) {
				if (p != -1 && !article[i].equals(article[p])) {
					distance = Math.min(distance, i - p);
				}
				p = i;
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		System.out.println(new Distance().getDistance(new String[] { "lab",
				"lab", "nhb", "nhb", "lab", "nhb", "nhb", "nhb", "lab" }, 9,
				"nhb", "lab"));
	}
}