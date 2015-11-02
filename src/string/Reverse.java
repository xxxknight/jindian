package string;

public class Reverse {
	public String reverseString(String iniString) {
		// write code here
		if (iniString == null || iniString.isEmpty()) {
			return "";
		}
		char[] arr = iniString.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}

		return String.valueOf(arr);

	}
	
	public static void main(String[] args) {
		System.out.println(new Reverse().reverseString("This is nowcoder"));
	}

}
