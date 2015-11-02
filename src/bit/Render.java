package bit;

import java.util.Arrays;

/**
 * ��Ŀ����
 * 
 * ��һ����ɫ��Ļ������һά�����У����������ÿ��Ԫ�ش���������8λ�����ص�ֵ����ʵ��һ������������x����y������Ϳ����ɫ(���ر�Ŵ��㿪ʼ)��
 * �����Ծ���ʹ�����İ취��
 * ������ʾ��Ļ������screen(�����е�ÿ��Ԫ�ش���������8�����أ��Ҵ������ҵ����طֱ��ӦԪ�صĶ����ƵĴӵ͵���λ)���Լ�int x,int
 * y��������������������֤�������ݺϷ����뷵��Ϳɫ����µ���Ļ���顣 ���������� [0,0,0,0,0,0],0,47
 * ���أ�[255,255,255,255,255,255]
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