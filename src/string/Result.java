package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ��Ŀ����
 * 
 * �����������ĸ��ۣ�ÿ���۷�һ������ɫ�����Ǻ�ɫ(R)����ɫ(Y)����ɫ(G)����ɫ(B)�����磬���ܵ����ΪRGGB(��1Ϊ��ɫ����2��3Ϊ��ɫ��
 * ��4Ϊ��ɫ
 * )����Ϊ��ң�����Ҫ��ͼ�³���ɫ����ϡ����磬����ܲ�YRGB��Ҫ����¶���ĳ���۵���ɫ������һ�Ρ����С���Ҫ��ֻ�ǲ¶�����ɫ����λ�´��ˣ�����һ��
 * ��α���С���ע�⣬�����С��������롰α���С��� ��������string
 * A��guess���ֱ��ʾ��ɫ��ϣ���һ���²⡣�뷵��һ��int���飬��һ��Ԫ��Ϊ���еĴ������ڶ���Ԫ��Ϊα���еĴ����� ����������
 * "RGBY","GGRR" ���أ�[1,1]
 * 
 * @author founder
 * 
 */

public class Result {
	public int[] calcResult(String A, String guess) {
		if (null == A || null == guess || A.length() != 4
				|| guess.length() != 4) {
			return null;
		}
		int[] res = new int[2];
		HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> h2 = new HashMap<Character, Integer>();
		h1.put('R', 0);
		h1.put('G', 0);
		h1.put('B', 0);
		h1.put('Y', 0);

		h2.put('R', 0);
		h2.put('G', 0);
		h2.put('B', 0);
		h2.put('Y', 0);

		int r1 = 0;
		int r2 = 0;

		for (int i = 0; i < 4; i++) {
			if (A.charAt(i) == guess.charAt(i)) {
				r1++;
			}
			if (h1.containsKey(A.charAt(i))) {
				h1.put(A.charAt(i), h1.get(A.charAt(i)) + 1);
			}
			if (h2.containsKey(guess.charAt(i))) {
				h2.put(guess.charAt(i), h2.get(guess.charAt(i)) + 1);
			}
		}

		r2 = Math.min(h1.get('R'), h2.get('R'))
				+ Math.min(h1.get('G'), h2.get('G'))
				+ Math.min(h1.get('B'), h2.get('B'))
				+ Math.min(h1.get('Y'), h2.get('Y')) - r1;

		res[0] = r1;
		res[1] = r2;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Result().calcResult("RGBY",
				"GGRR")));
	}
}