package linkedlist;

/**
 * ��Ŀ����
 * 
 * ��д���룬�Ը���ֵxΪ��׼������ָ�������֣�����С��x�Ľ�����ڴ��ڻ����x�Ľ��֮ǰ ����һ�������ͷָ�� ListNode*
 * pHead���뷵���������к�������ͷָ�롣ע�⣺�ָ��Ժ󱣳�ԭ��������˳�򲻱䡣
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