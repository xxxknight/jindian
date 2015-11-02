package tree;

import java.util.Stack;

import linkedlist.ListNode;

/**
 * 题目描述 有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。 其可以用来表示二叉查找树(其中left指针表示左儿子，
 * right指针表示右儿子
 * )。请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
 * 给定二叉查找树的根结点指针root，请返回转换成的链表的头指针。
 * 
 * @author founder
 * 
 */
public class Converter {
	public ListNode treeToList(TreeNode root) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root !=null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				p.next = new ListNode(root.val);
				p = p.next;
				root = root.right;
			}
		}
		return dummy.next;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
