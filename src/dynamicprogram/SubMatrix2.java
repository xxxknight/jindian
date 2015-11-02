package dynamicprogram;

/**
 * 题目描述
 * 
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。 测试样例：
 * [[1,1,1],[1,0,1],[1,1,1]],3 返回：3
 * 
 * @author founder
 * 
 */

public class SubMatrix2 {
	public int maxSubMatrix(int[][] a, int n) {
		// write code here
		int r = 0;
		for (int len = 0; len <= n; len++) {
			for (int row = 0; row < n; row++) {
				if (row + len > n)
					break;
				for (int col = 0; col < n; col++) {
					if (col + len > n)
						break;
					int point = a[row][col];
					int i = 0;
					for (; i < len; i++) {
						if (a[row][col + i] != point)
							break;
						if (a[row + i][col] != point)
							break;
						if (a[row + len - 1][col + i] != point)
							break;
						if (a[row + i][col + len - 1] != point)
							break;
					}
					if (len > r && i == len)
						r = len;
				}
			}
		}
		return r;
	}
}