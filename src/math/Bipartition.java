package math;

/**
 * 题目描述
 * 
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
 * 给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。 测试样例：
 * [(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)] 返回：[0.0，0.5]
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