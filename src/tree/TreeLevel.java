package tree;

import java.util.LinkedList;
import java.util.Queue;

import linkedlist.ListNode;

/**
 * 题目描述
 * 
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。 给定二叉树的根结点指针TreeNode*
 * root，以及链表上结点的深度，请返回一个链表ListNode
 * ，代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
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
