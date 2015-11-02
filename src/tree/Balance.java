package tree;

import java.util.zip.Inflater;

/**
 * ��Ŀ����
 * 
 * ʵ��һ�����������������Ƿ�ƽ�⣬ƽ��Ķ������£��������е�����һ����㣬�����������ĸ߶Ȳ����1�� ����ָ����������ָ��TreeNode*
 * root���뷵��һ��bool������������Ƿ�ƽ�⡣
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
