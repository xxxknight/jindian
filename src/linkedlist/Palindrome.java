package linkedlist;

/**
 * 题目描述
 * 
 * 请编写一个函数，检查链表是否为回文。 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。 测试样例：
 * {1,2,3,2,1} 返回：true {1,2,3,2,3} 返回：false
 * 
 * @author founder
 * 
 */
public class Palindrome {
	public boolean isPalindrome(ListNode pHead) {
		// write code here
		if (pHead == null || pHead.next == null) {
			return true;
		}
		ListNode fast = pHead;
		ListNode slow = pHead;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast.next != null) {
			fast = fast.next;
		}
		slow.next = reverseLinkedList(slow.next);
		ListNode l1 = pHead;
		ListNode l2 = slow.next;
		while (l1 != null && l2 != null) {
			if (l1.val == l2.val) {
				l1 = l1.next;
				l2 = l2.next;
			}else{
				return false;
			}
		}

		return true;
	}

	// 翻转链表
	public ListNode reverseLinkedList(ListNode head) {
		ListNode prev = new ListNode(0);
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev.next;
			prev.next = head;
			head = temp;
		}
		return prev.next;
	}

	public static void main(String[] args) {
		
	}
}