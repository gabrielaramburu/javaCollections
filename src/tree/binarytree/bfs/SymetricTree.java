package tree.binarytree.bfs;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false

 */
public class SymetricTree {
	private List<Integer> levelValues = new ArrayList<Integer>();

	public static void main(String[] args) {
		SymetricTree mirror = new SymetricTree();

		boolean result = mirror.isSymmetric(mirror.new TreeNode(1, 
						mirror.new TreeNode(2, mirror.new TreeNode(3), mirror.new TreeNode(4)), 
						mirror.new TreeNode(2, mirror.new TreeNode(4), mirror.new TreeNode(4))));
		
		
		System.out.println("Result " + result);
	}

	public boolean isSymmetric(TreeNode root) {
		int treeLevel = calcTreeDepth(root, 0);
		for (int level = 1; level <= treeLevel; level++) {
			levelTraversal(root, level);
			if (!symetricValues()) {
				return false;
			} else
				levelValues = new ArrayList<Integer>();
		}
		return true;
	}

	private boolean symetricValues() {
		this.levelValues.stream().forEach(item -> System.out.println(item + ","));
		if (this.levelValues.size() == 1) return true;
		else {
			int size = this.levelValues.size() - 1;
			List<Integer> leftSide = levelValues.subList(0, size/2 + 1);
			List<Integer> lefRSide = levelValues.subList(size/2 + 1, this.levelValues.size());
			Collections.reverse(lefRSide);
			return leftSide.equals(lefRSide);
		}
	}

	private void levelTraversal(TreeNode node, int level) {
		if (node == null) {
			levelValues.add(null);
		} else {
			if (level == 1) {
				levelValues.add(node.val);
			} else {
				levelTraversal(node.left, level - 1);
				levelTraversal(node.right, level - 1);
			}
		}
	}

	private int calcTreeDepth(TreeNode node, int level) {
		if (node == null)
			return level;

		int lmd = calcTreeDepth(node.left, level + 1);
		int rmd = calcTreeDepth(node.right, level + 1);
		return Math.max(lmd, rmd);
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
