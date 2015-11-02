package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 
 * 现有一些随机生成的数字要将其依次传入，请设计一个高效算法，对于每次传入一个数字后，算出当前所有传入数字的中位数。 (若传入了偶数个数字则令中位数为第n/2
 * 小的数字，n为已传入数字个数)。 给定一个int数组A，为传入的数字序列，同时给定序列大小n，请返回一个int数组，代表每次传入后的中位数。
 * 保证n小于等于1000。 测试样例： [1,2,3,4,5,6],6 返回：[1,1,2,2,3,3]
 * 
 * @author founder
 * 
 */

public class Middle {
	// maxHeap存放数组的较小的一半数，minHeap存放数组较大的一半数
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