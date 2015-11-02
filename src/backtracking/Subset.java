package backtracking;

/**
 ��Ŀ����
 ���дһ������������ĳ���ϵ����зǿ��Ӽ���
 ����һ��int����A������Ĵ�Сint n���뷵��A�����зǿ��Ӽ�����֤A��Ԫ�ظ���С�ڵ���20����Ԫ�ػ��졣
 ���Ӽ���˳��Ϊ��Ԫ��p�Ӵ�С������ֵ���Ӵ�С����������
 ����������
 [123,456,789]
 ���أ�[[789],[456,789],[456],[123,789],[123,456,789],[123,456],[123]]
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����˼·�� ��n-1�����������Ӽ��Ļ���������n�����������Ӽ���sets(n)ͨ�����²����ã� 1.
 * ��sets(n-1)�������Ӽ�ǰ�߲��뵱ǰԪ��A[n-1]�� 2. A[n-1]������Ϊһ���Ӽ�[A[n-1]]�� 3.
 * sets(n-1)ͬʱҲӦ������sets(n)�С� �ٸ����ӣ� A={1,2,3}; 1.��������һ��Ԫ�ص��Ӽ�sets(1)={{1}}��
 * 2.����Ԫ��2����sets(2)����������ɣ� ��1����sets(1)�������Ӽ�ǰ�߲��뵱ǰԪ��A[1]=2���õ�{{2,1}}��
 * ��2��A[1]������Ϊһ���Ӽ�{2}�� ��3��sets(1)ͬʱҲӦ������sets(2)�У�sets(3) = {{2,1},{2},{1}}��
 * 3.����Ԫ��3����sets(3)����������ɣ� ��1����sets(2)�������Ӽ�ǰ�߲��뵱ǰԪ��A[2]=3���õ�
 * {{3,2,1},{3,2},{3,1}}�� ��2��A[2]������Ϊһ���Ӽ�{3}�� ��3��sets(2)ͬʱҲӦ������sets(3)�У�sets(3)
 * = {{3,2,1},{3,2},{3,1},{3},{2,1},{2},{1}}��
 * 
 * @author founder
 * 
 */
public class Subset {
	public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		if (A == null || A.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(A);// ����A��С��������
		return getSubsetsCore(A, n);
	}

	public ArrayList<ArrayList<Integer>> getSubsetsCore(int[] A, int n) {
		ArrayList<ArrayList<Integer>> outter = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner;
		if (n == 1) {// ѭ����ֹ����
			inner = new ArrayList<Integer>();
			inner.add(A[0]);
			outter.add(inner);
			return outter;
		}
		ArrayList<ArrayList<Integer>> tmp = getSubsetsCore(A, n - 1);
		int i, j;
		for (i = 0; i < tmp.size(); i++) {// 1. ��sets(n-1)�������Ӽ�ǰ�߲��뵱ǰԪ��A[n-1]��
			inner = new ArrayList<Integer>();
			inner.add(A[n - 1]);
			for (j = 0; j < tmp.get(i).size(); j++) {
				inner.add(tmp.get(i).get(j));
			}
			outter.add(inner);
		}
		inner = new ArrayList<Integer>();
		inner.add(A[n - 1]);
		outter.add(inner);// 2. A[n-1]������Ϊһ���Ӽ�[A[n-1]]��
		outter.addAll(tmp);// 3. sets(n-1)ͬʱҲӦ������sets(n)�С�
		return outter;
	}

	public static void main(String[] args) {
		System.out.println(new Subset().getSubsets(new int[] { 0, 1, 2, 3, 4,
				5, 6, 7, 8, 9 }, 10));
	}
}