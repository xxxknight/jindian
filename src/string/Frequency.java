package string;

/**
 * 题目描述
 * 
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 * 
 * @author founder
 * 
 */
public class Frequency {
	public int getFrequency(String[] article, int n, String word) {
		// write code here
		int res = 0;
		for (String sen : article) {
			if (sen.equals(word)) {
				res++;
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
