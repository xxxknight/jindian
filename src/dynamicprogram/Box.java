package dynamicprogram;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����
 * 
 * ��һ�����ӣ�ÿ�����ӿ�Ϊwi����Ϊdi����Ϊhi��������Ҫ�����Ӷ��������� ����Ϊ��ʹ�����������Ӳ�����
 * ��������ӵĿ�Ⱥͳ��ȱ��������������ӡ�
 * ��ʵ��һ������������ܶѳ�����ߵĸ߶ȣ�����ĸ߶ȼ����������������ӵĸ߶�֮�͡�
 * ��������int����w,l,h���ֱ��ʾÿ�����ӿ����͸ߣ�ͬʱ�������ӵ���Ŀn�� �뷵���ܶѳɵ���ߵĸ߶ȡ���֤nС�ڵ���500�� 
 * ����������
 * [1,1,1],[1,1,1],[1,1,1] ���أ�1
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
