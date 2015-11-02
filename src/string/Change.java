package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 题目描述
 * 
 * 现有一个字典，同时给定字典中的两个字符串s和t，给定一个变换， 每次可以改变字符串中的任意一个字符，请设计一个算法，计算由s变换到t所需的最少步数，
 * 同时需要满足在变换过程中的每个串都是字典中的串。
 * 给定一个string数组dic，同时给定数组大小n，串s和串t，请返回由s到t变换所需的最少步数。若无法变换到t则返回
 * -1。保证字符串长度均小于等于10，且字典中字符串数量小于等于500。 测试样例：
 * ["abc","adc","bdc","aaa”],4,”abc","bdc" 返回：2
 * 
 * @author founder
 * 
 */

public class Change {
	public int countChanges(String[] dic, int n, String s, String t) {
		// write code here
		if (null == s || null == t || 0 == s.length() || 0 == t.length()) {
			return -1;
		}
		List<String> list = Arrays.asList(dic);
		Queue<String> queue = new LinkedList<String>();
		Set<String> visit = new HashSet<String>();
		Map<String, String> map = new TreeMap<String, String>();
		queue.add(s);
		visit.add(s);

		while (!queue.isEmpty()) {
			String w = queue.poll();
			for (String v : getOneEditWords(w)) {
				if (v.equals(t)) {
					int res = 1;
					while (w != null) {
						res++;
						w = map.get(w);
					}
					return res;
				}
				if (list.contains(v) && !visit.contains(v)) {
					queue.add(v);
					visit.add(v);
					map.put(v, w);
				}

			}
		}

		return -1;
	}

	public Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != word.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}

	public static void main(String[] args) {
		String[] dict = { "vvz", "bbaa", "f", "bbba", "bbaa", "baoa", "btoa",
				"bbba", "dcki", "bbbb", "ge", "atoj", "baaa", "btoj", "ae" };
		System.out.println(new Change().countChanges(dict, 15, "atoj", "bbbb"));
	}
}