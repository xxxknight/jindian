package dynamicprogram;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 
 * 有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来， 而且为了使堆起来的箱子不到，
 * 上面的箱子的宽度和长度必须大于下面的箱子。
 * 请实现一个方法，求出能堆出的最高的高度，这里的高度即堆起来的所有箱子的高度之和。
 * 给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。 请返回能堆成的最高的高度。保证n小于等于500。 
 * 测试样例：
 * [1,1,1],[1,1,1],[1,1,1] 返回：1
 * 
 * @author founder
 * 
 */

public class Box {
	class MyBox implements Comparator<MyBox> {
		int w;
		int l;
		int h;

		public MyBox(int w, int l, int h) {
			this.w = w;
			this.l = l;
			this.h = h;
		}

		public MyBox() {
		}

		public int compare(MyBox o1, MyBox o2) {
			return o1.w < o2.w ? 1 : (o1.w == o2.w ? 0 : -1);
		}

	}

	public int getHeight(int[] w, int[] l, int[] h, int n) {
		// write code here
		MyBox[] box = new MyBox[n];
		int[] high = new int[n];

		for (int i = 0; i < n; i++) {
			box[i] = new MyBox(w[i], l[i], h[i]);
		}

		Arrays.sort(box, new MyBox());

		high[0] = box[0].h;
		int max = high[0];

		for (int i = 1; i < n; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				if ((box[i].w < box[j].w) && (box[i].l < box[j].l)) {
					tmp = Math.max(high[j], tmp);
				}
			}
			high[i] = tmp + box[i].h;
			max = Math.max(max, high[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] w = { 1, 2, 3 };
		int[] l = { 1, 2, 3 };
		int[] h = { 1, 2, 3 };

		System.out.println(new Box().getHeight(w, l, h, 3));
	}
}
