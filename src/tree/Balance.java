package tree;

import java.util.zip.Inflater;

/**
 * 题目描述
 * 
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。 给定指向树根结点的指针TreeNode*
 * root，请返回一个bool，代表这棵树是否平衡。
 * 
 * @author founder
 * 
 */
public class Balance {
	public boolean isBalance(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		int diff = left - right;
		if (diff > 1 || diff < -1) {
			return false;
		} else {
			return isBalance(root.left) && isBalance(root.right);
		}
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

}
