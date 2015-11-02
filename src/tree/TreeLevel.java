package tree;

import java.util.LinkedList;
import java.util.Queue;

import linkedlist.ListNode;

/**
 * ��Ŀ����
 * 
 * ����һ�ö������������һ���㷨����������ĳһ��������н������� �����������ĸ����ָ��TreeNode*
 * root���Լ������Ͻ�����ȣ��뷵��һ������ListNode
 * ���������������н���ֵ���밴���ϴ������ҵ�˳�����ӣ���֤��Ȳ��������ĸ߶ȣ����Ͻ���ֵΪ�Ǹ������Ҳ�����100000��
 * 
 * @author founder
 * 
 */
public class TreeLevel {
	public ListNode getTreeLevel(TreeNode root, int dep) {
		// write code here
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int k = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode temp = queue.poll();
				if (k == dep) {
					p.next = new ListNode(temp.val);
					p = p.next;
				}
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
				size--;
			}
			if (k == dep) {
				return dummy.next;
			} else {
				k++;
			}

		}
		return null;

	}

	public static void main(String[] args) {

	}

}
