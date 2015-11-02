package math;

/**
 * ��Ŀ����
 * 
 * �ڶ�άƽ���ϣ������������Σ����ҳ�һ��ֱ�ߣ��ܹ��������������ζ԰�֡��ٶ������ε�������������x��ƽ�С�
 * ��������vecotrA��B���ֱ�Ϊ���������ε��ĸ����㡣�뷵��һ��vector�����������ƽ��ֱ�ߵ�б�ʺͽؾ࣬��֤б�ʴ��ڡ� ����������
 * [(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)] ���أ�[0.0��0.5]
 * 
 * @author founder
 * 
 */

public class Bipartition {
	public double[] getBipartition(Point[] A, Point[] B) {
		// write code here
		double x1 = (A[0].x + A[2].x) / 2.0;
		double y1 = (A[0].y + A[2].y) / 2.0;

		double x2 = (B[0].x + B[2].x) / 2.0;
		double y2 = (B[0].y + B[2].y) / 2.0;

		double slope = (y2 - y1) / (x2 - x1);
		double distance = y1 - slope * x1;
		return new double[] { slope, distance };
	}

	public static void main(String[] args) {

	}
}