package tree;

/**
 * 题目描述
 * 
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。 给定一个有序序列int[]
 * vals,请返回创建的二叉查找树的高度。
 * 
 * @author founder
 * 
 */
public class MinimalBST {

	public int buildMinimalBST(int[] vals) {
		// write code here
		TreeNode node = helper(vals, 0, vals.length - 1);
		
		return getDepth(node);
	}

	public TreeNode helper(int[] vals, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(vals[mid]);
		root.left = helper(vals, start, mid - 1);
		root.right = helper(vals, mid + 1, end);
		return root;
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}
	
	public int buildMinimalBST2(int[] vals) {
		
		return (int) Math.ceil(Math.log(vals.length))+1;
	}
	
	public static void main(String[] args) {
		System.out.println(new MinimalBST().buildMinimalBST2(new int[]{0,1,2,3,4,5,6,7,8}));
	}

}