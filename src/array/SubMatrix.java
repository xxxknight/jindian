package array;

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

public class SubMatrix {
	public int maxSubMatrix(int[][] mat, int n) {
		// write code here
		if (null == mat || 0 == mat.length) {
			return 0;
		}
		int len = mat.length;
		int x = 0;
		int y = 0;
		while (len > 0) {
			if (len == 1) {
				if (mat[x][y] == 1) {
					return 1;
				}
			}
			if (helper(mat, len, x, y)) {
				return len;
			}

			x++;
			y++;
			len -= 2;
		}
		return 0;
	}

	private boolean helper(int[][] mat, int len, int x, int y) {
		for (int i = 0; i < len - 1; i++) {
			if (mat[x][y + i] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + i][y + len - 1] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + len - 1][y + len - 1 - i] == 1) {
				continue;
			} else {
				return false;
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (mat[x + len - 1 - i][y] == 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] res = {{1,1,1,0,0},{1,1,1,0,1},{0,0,0,0,0},{1,0,1,1,0},{1,0,0,0,1}};
		System.out.println(new SubMatrix().maxSubMatrix(res, 5));
	}
}