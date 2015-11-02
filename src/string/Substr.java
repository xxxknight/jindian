package string;

import java.util.Arrays;

public class Substr {
	public boolean[] chkSubStr(String[] p, int n, String s) {
		// write code here
		boolean[] flag = new boolean[n];
		Arrays.fill(flag, false);
		for (int i = 0; i < n; i++) {
			if (s.contains(p[i])) {
				flag[i] = true;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		System.out.println(new Substr().chkSubStr(new String[] { "a", "b", "c",
				"d" }, 4, "abc"));
	}
}