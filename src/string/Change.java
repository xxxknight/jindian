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
 * ��Ŀ����
 * 
 * ����һ���ֵ䣬ͬʱ�����ֵ��е������ַ���s��t������һ���任�� ÿ�ο��Ըı��ַ����е�����һ���ַ��������һ���㷨��������s�任��t��������ٲ�����
 * ͬʱ��Ҫ�����ڱ任�����е�ÿ���������ֵ��еĴ���
 * ����һ��string����dic��ͬʱ���������Сn����s�ʹ�t���뷵����s��t�任��������ٲ��������޷��任��t�򷵻�
 * -1����֤�ַ������Ⱦ�С�ڵ���10�����ֵ����ַ�������С�ڵ���500�� ����������
 * ["abc","adc","bdc","aaa��],4,��abc","bdc" ���أ�2
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