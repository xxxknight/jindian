package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��Ŀ����
 * 
 * ����һЩ������ɵ�����Ҫ�������δ��룬�����һ����Ч�㷨������ÿ�δ���һ�����ֺ������ǰ���д������ֵ���λ���� (��������ż��������������λ��Ϊ��n/2
 * С�����֣�nΪ�Ѵ������ָ���)�� ����һ��int����A��Ϊ������������У�ͬʱ�������д�Сn���뷵��һ��int���飬����ÿ�δ�������λ����
 * ��֤nС�ڵ���1000�� ���������� [1,2,3,4,5,6],6 ���أ�[1,1,2,2,3,3]
 * 
 * @author founder
 * 
 */

public class Middle {
	// maxHeap�������Ľ�С��һ������minHeap�������ϴ��һ����
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(20,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		if (maxHeap.size() - minHeap.size() >= 2) {
			minHeap.offer(maxHeap.poll());
		}
		if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
			maxHeap.offer(minHeap.poll());
			minHeap.offer(maxHeap.poll());
		}
	}

	// Returns the median of current data stream
	public int findMedian() {
		return maxHeap.peek();
	}

	public int[] getMiddle(int[] A, int n) {
		// write code here
		if (n <= 0) {
			return null;
		}
		int[] res = new int[n];
		for (int i = 0; i < A.length; i++) {
			addNum(A[i]);
			res[i] = findMedian();
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Middle().getMiddle(
				new int[] { 1, 2, 3, 4, 5, 6 }, 6));
	}
}