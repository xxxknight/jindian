package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目描述
 * 
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，
 * 槽4为蓝色
 * )，作为玩家，你需要试图猜出颜色的组合。比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，则算一次
 * “伪猜中”。注意，“猜中”不能算入“伪猜中”。 给定两个string
 * A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。 测试样例：
 * "RGBY","GGRR" 返回：[1,1]
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