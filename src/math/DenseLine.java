package math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 题目描述
 * 
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。 给定一个点集vector
 * p和点集的大小n，请返回一个vector，代表经过点数最多的那条直线的斜率和截距。
 * 
 * @author founder
 * 
 */

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this.x = 0;
		this.y = 0;
	}
}



public class DenseLine {
	public double[] getLine(Point[] p, int n) {
		// write code here
		HashMap<Point2, Integer> hs = new HashMap<Point2, Integer>();
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				double slope = (double) (p[i].y - p[j].y)
						/ (double) (p[i].x - p[j].x);
				double intercept = (double) p[i].y - (slope * p[i].x);
				Point2 temp = new Point2(slope, intercept);
				if (hs.containsKey(temp)) {
					hs.put(temp, hs.get(temp) + 1);
				} else {
					hs.put(temp, 1);
				}
			}
		}
		int max = 0;
		Point2 res = null;
		Iterator<Entry<Point2, Integer>> iterator = hs.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Point2, Integer> entry = iterator.next();
			int value = entry.getValue();
			if (value > max) {
				max = value;
				res = entry.getKey();
			}
		}
		double[] info = new double[2];
		info[0] = res.k;
		info[1] = res.b;
		return info;

	}
	class Point2 {
		double k;
		double b;

		public Point2(double k, double b) {
			super();
			this.k = k;
			this.b = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(b);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(k);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point2 other = (Point2) obj;
			if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
				return false;
			if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
				return false;
			return true;
		}

	}

	public static void main(String[] args) {

	}
}
