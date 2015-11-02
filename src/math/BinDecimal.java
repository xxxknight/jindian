package math;

/**
 * ��Ŀ����
 * 
 * ��һ������0��1֮���ʵ��������Ϊdouble���������Ķ����Ʊ�ʾ�� ����������޷���ȷ����32λ���ڵĶ����Ʊ�ʾ�����ء�Error����
 * ����һ��double num����ʾ0��1��ʵ�����뷵��һ��string����������Ķ����Ʊ�ʾ���ߡ�Error���� ���������� 0.625 ���أ�0.101
 * 
 * @author founder
 * 
 */

public class BinDecimal {
	public String printBin(double num) {
		// write code here
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		double base = 0.5;
		while (num > 0) {
			if (num >= base) {
				sb.append("1");
				num -= base;
			} else {
				sb.append("0");
			}
			if (sb.length() > 32) {
				return "Error";
			}
			base /= 2;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new BinDecimal().printBin(0.625));
	}
}