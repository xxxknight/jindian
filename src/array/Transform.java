package array;

/**
 * ��Ŀ����
 * 
 * ��һ����NxN�����ʾ��ͼ������ÿ��������һ��int��ʾ�����дһ���㷨���ڲ�ռ�ö����ڴ�ռ�������(����ʹ�û������)����ͼ��˳ʱ����ת90�ȡ�
 * ����һ��NxN�ľ��󣬺;���Ľ���N,�뷵����ת���NxN����,��֤NС�ڵ���500��ͼ��Ԫ��С�ڵ���256�� ����������
 * [[1,2,3],[4,5,6],[7,8,9]],3 ���أ�[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * @author founder
 * 
 */
public class Transform {
	public int[][] transformImage(int[][] mat, int n) {
		// write code here
		if (mat == null || n <= 1) {
			return mat;
		}
		int x = 0;
		while (n > 1) {
			for (int i = 0; i < n - 1; i++) {
				int temp = mat[x][x + i];
				mat[x][x + i] = mat[x + n - 1 - i][x];
				mat[x + n - 1 - i][x] = mat[x + n - 1][x + n - 1 - i];
				mat[x + n - 1][x + n - 1 - i] = mat[x + i][x + n - 1];
				mat[x + i][x + n - 1] = temp;
			}
			x++;
			n = n - 2;
		}
		return mat;

	}

	public static void main(String[] args) {

	}

}
