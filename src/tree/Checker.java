package tree;

/**
 * 题目描述
 * 
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 * 
 * @author founder
 * 
 */
public class Checker {
	public boolean isValidBST(TreeNode root) {
		long high = Integer.MAX_VALUE;
		long low = Integer.MIN_VALUE;
		high++;
		low--;
		return helper(root, low, high);

	}

	public boolean helper(TreeNode treeNode, long low, long high) {
		if (treeNode == null) {
			return true;
		}
		if (low < treeNode.val && treeNode.val < high) {
			return helper(treeNode.left, low, treeNode.val)
					&& helper(treeNode.right, treeNode.val, high);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(3);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		System.out.println(new Checker().isValidBST(root));
	}

}
