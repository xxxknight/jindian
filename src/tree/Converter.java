package tree;

import java.util.Stack;

import linkedlist.ListNode;

/**
 * ��Ŀ���� ��һ�����ƽ������ݽṹTreeNode��������val���Ժ�ָ����������ָ�롣 �����������ʾ���������(����leftָ���ʾ����ӣ�
 * rightָ���ʾ�Ҷ���
 * )�����дһ�������������������ת��Ϊһ���������ж�������������ݽṹ��TreeNodeʵ�֣���������ݽṹ��ListNodeʵ�֡�
 * ��������������ĸ����ָ��root���뷵��ת���ɵ������ͷָ�롣
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
