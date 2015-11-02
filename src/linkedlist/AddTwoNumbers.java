package linkedlist;

public class AddTwoNumbers {
	public ListNode plusAB(ListNode a, ListNode b) {
		// write code here
		ListNode result = new ListNode(0);
		ListNode head = result;
		int flag = 0;
		while (a != null && b != null) {
			int sum = a.val + b.val + flag;
			int val = sum % 10;
			flag = sum / 10;
			ListNode temp = new ListNode(val);
			temp.next = result.next;
			result.next = temp;
			result = temp;
			a = a.next;
			b = b.next;
		}
		while (a != null) {
			int sum = a.val + flag;
			int val = sum % 10;
			flag = sum / 10;
			ListNode temp = new ListNode(val);
			temp.next = result.next;
			result.next = temp;
			result = temp;
			a = a.next;
		}
		while (b != null) {
			int sum = b.val + flag;
			int val = sum % 10;
			flag = sum / 10;
			ListNode temp = new ListNode(val);
			temp.next = result.next;
			result.next = temp;
			result = temp;
			b = b.next;
		}
		if (flag == 1) {
			ListNode temp = new ListNode(1);
			temp.next = result.next;
			result.next = temp;
			result = temp;
		}

		return head.next;
	}
}
