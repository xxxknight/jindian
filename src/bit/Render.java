package bit;

import java.util.Arrays;

/**
 * 题目描述
 * 
 * 有一个单色屏幕储存在一维数组中，其中数组的每个元素代表连续的8位的像素的值，请实现一个函数，将第x到第y个像素涂上颜色(像素标号从零开始)，
 * 并尝试尽量使用最快的办法。
 * 给定表示屏幕的数组screen(数组中的每个元素代表连续的8个像素，且从左至右的像素分别对应元素的二进制的从低到高位)，以及int x,int
 * y，意义如题意所述，保证输入数据合法。请返回涂色后的新的屏幕数组。 测试样例： [0,0,0,0,0,0],0,47
 * 返回：[255,255,255,255,255,255]
 * 
 * @author founder
 * 
 */

public class Render {
	public int[] renderPixel(int[] screen, int x, int y) {
		int remainX = x % 8;
		int divideX = x / 8;
		int remainY = y % 8;
		int divideY = y / 8;

		if (divideX == divideY) {
			screen[divideX] |= (1 << (remainY + 1)) - (1 << remainX);
		} else {
			screen[divideX] |= (1 << 8) - (1 << (remainX));
			for (int i = divideX + 1; i < divideY; i++) {
				screen[i] = 255;
			}
			screen[divideY] |= (1 << (remainY + 1)) - 1;

		}
		return screen;
	}

	public static void main(String[] args) {
		int[] screen = { 58, 211, 111, 90, 248, 124, 27, 226, 39, 43, 124, 183,
				182, 141, 133, 12, 233, 227, 27, 103, 216, 14, 187, 200, 254,
				255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255,
				255, 255, 243, 196 };
		int x = 194;
		int y = 313;
		System.out.println(Arrays.toString(new Render().renderPixel(screen, x,
				y)));
	}
}