package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ��Ŀ����
 * 
 * ����һ������ͼ����ʵ��һ���㷨���ҳ�����֮���Ƿ����һ��·���� ����ͼ�е���������ָ��UndirectedGraphNode*
 * a,UndirectedGraphNode* b(�벻Ҫ�����������ͣ�ͼ������ͼ),�뷵��һ��bool����������֮���Ƿ����һ��·��(a��b��b��a)��
 * 
 */

public class Path {
	/**
	 * �ǵݹ���ʽ �����գ�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		if (null == a || null == b) {
			return false;
		}
		return isDirect(a, b) || isDirect(b, a);// ��Ĺ�ϵ������һ������
	}

	private boolean isDirect(UndirectedGraphNode node1,
			UndirectedGraphNode node2) {
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();// ������ȱ������ö��д洢ÿһȦ�Ľڵ�
		queue.add(node1);
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();// ��¼���ʹ��Ľڵ�

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
	 * �ݹ���ʽ�ģ��˽⣩
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
