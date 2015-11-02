package linkedlist;

/**
 * 题目描述
 * 
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 给定一个链表的头指针 ListNode*
 * pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 * 
 * @author founder
 * 
 */

public class Partition {
	public ListNode partition(ListNode pHead, int x) {
		// write code here
		ListNode dummy0 = new ListNode(0);
		ListNode dummy1 = new ListNode(1);

		ListNode temp0 = dummy0;
		ListNode temp1 = dummy1;

		ListNode p = pHead;

		while (p != null) {
			ListNode temp = p.next;
			p.next = null;
			if (p.val < x) {
				temp0.next = p;
				p = temp;
				temp0 = temp0.next;
			} else {
				temp1.next = p;
				p = temp;
				temp1 = temp1.next;
			}
		}
		temp0.next = dummy1.next;
		return dummy0.next;

	}

	public static void main(String[] args) {

	}
}