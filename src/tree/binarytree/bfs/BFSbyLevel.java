package tree.binarytree.bfs;

import java.util.ArrayList;
import java.util.List;

public class BFSbyLevel {
	//List of list
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> valuesByLevel = new ArrayList<Integer>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		//first calc the tree level
		int treeLevel = calcTreeLevel(root, 0);
		
		for (int i = 1; i < treeLevel + 1; i++) {
			showLevel(root, i);
			
			if (!valuesByLevel.isEmpty()) result.add(valuesByLevel);
			valuesByLevel = new ArrayList<Integer>();
		}
		return result;
	}

	private void showLevel(TreeNode node, int level) {
		//well know (not so easy to understand) algorithm for level tree traversal  
		if (node != null) {
			if (level == 1) {
				valuesByLevel.add(node.val);
			} else {
				showLevel(node.left, level - 1);
				showLevel(node.right, level - 1);
			}
		}
	}

	private int calcTreeLevel(TreeNode node, int maxLevel) {
		//the tree are not necesary comple o perfect
		if (node == null)
			return maxLevel;

		int maxLevelLeft = calcTreeLevel(node.left, maxLevel + 1);
		int maxLevelRight = calcTreeLevel(node.right, maxLevel + 1);

		return Math.max(maxLevelLeft, maxLevelRight);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
