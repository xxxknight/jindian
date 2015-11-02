package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 题目描述
 * 
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。 给定图中的两个结点的指针UndirectedGraphNode*
 * a,UndirectedGraphNode* b(请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 * 
 */

public class Path {
	/**
	 * 非递归形式 （掌握）
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		if (null == a || null == b) {
			return false;
		}
		return isDirect(a, b) || isDirect(b, a);// 或的关系，存在一条即可
	}

	private boolean isDirect(UndirectedGraphNode node1,
			UndirectedGraphNode node2) {
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();// 广度优先遍历，用队列存储每一圈的节点
		queue.add(node1);
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();// 记录访问过的节点

		while (!queue.isEmpty()) {
			UndirectedGraphNode temp = queue.poll();
			set.add(temp);
			if (node2 == temp) {
				return true;
			}
			for (UndirectedGraphNode node : temp.neighbors) {
				if (!set.contains(node)) {
					queue.offer(node);
				}
			}
		}
		return false;
	}

	/**
	 * 递归形式的（了解）
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean checkPath2(UndirectedGraphNode a, UndirectedGraphNode b) {
		if (null == a || null == b) {
			return false;
		}
		Set<UndirectedGraphNode> flag = new HashSet<UndirectedGraphNode>();
		boolean res = helper(a, b, flag);
		flag.clear();
		return res || helper(b, a, flag);
	}

	private boolean helper(UndirectedGraphNode node1,
			UndirectedGraphNode node2, Set<UndirectedGraphNode> flag) {
		if (node1 == node2) {
			return true;
		}
		flag.add(node1);
		for (int i = 0; i < node1.neighbors.size(); i++) {
			if (!flag.contains(node1.neighbors.get(i))
					&& helper(node1.neighbors.get(i), node2, flag)) {
				return true;
			}
		}
		return false;
	}
}
