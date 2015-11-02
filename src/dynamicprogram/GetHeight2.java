package dynamicprogram;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����
 * 
 * ���޺���һ����������Ϸ����Ϸ��һ����Ҫվ����һ���˵ļ���ϡ�Ϊ��ʹ���ɵ��޺����ȹ̣�����Ӧ����������˱�������˸���һ�㡣����һ����Ϸ��Ҫ���������Ŀ��
 * Ϊ���Ӿ�Ч�������ǻ�Ҫ��������˵���߱�������˸ߡ����дһ���㷨����������ܵ������ˣ�ע������������Ա��ͬʱ���֡�
 * ����һ����άint������actors��ÿ��Ԫ��������ֵ���ֱ����һ����Ա����ߺ����ء�ͬʱ������Ա����n���뷵������ܵ�����������֤������С�ڵ���500��
 * ���������� [[1,2],[3,4],[5,6],[7,8]],4 ���أ�4
 * 
 * @author founder
 * 
 */

public class GetHeight2 {
	public int getHeight(int[][] actors, int n) {
		// write code here
		int[] dp = new int[n];
		sort(actors);
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (compare(actors[i], actors[j]) && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = 1;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;

	}

	public void sort(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j][0] < arr[index][0]) {
					index = j;

				}
			}
			if (index != i) {
				int[] temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}

	public boolean compare(int[] a1, int[] a2) {
		return (a1[0] > a2[0]) && (a1[1] > a2[1]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
