package tree.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LessCommonAncestor {

	private List<Integer> pPath = new ArrayList<Integer>();
	private List<Integer> qPath = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		LessCommonAncestor lessCommon = new LessCommonAncestor();
		TreeNode root = lessCommon.new TreeNode(3, lessCommon.new TreeNode(5, lessCommon.new 
				TreeNode(6),
				lessCommon.new TreeNode(2, lessCommon.new TreeNode(8, lessCommon.new TreeNode(7), lessCommon.new TreeNode(9)), lessCommon.new TreeNode(10))), 
				lessCommon.new TreeNode(1));
		
		lessCommon.lowestCommonAncestor(root, lessCommon.new TreeNode(9), lessCommon.new TreeNode(10));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNodesInTree(root, p.val, pPath);
        findNodesInTree(root, q.val, qPath);
        TreeNode result = findLessCommonAncestor();
        return result;
 
   }
	
	private TreeNode findLessCommonAncestor() {
		List<Integer> longest;
		List<Integer> sortest;
		if (pPath.size() >= qPath.size()) {
			longest = pPath; sortest = qPath;
		} else {
			longest = qPath; sortest = pPath;
		}

		Map<Integer, Integer> longestPath = longest.stream().collect(Collectors.toMap(key -> key, Integer::new));
		
		for (int i = 0; i < sortest.size() ; i++) {
			if (longestPath.get(sortest.get(i)) != null) {
				return new TreeNode(sortest.get(i));
			}
		}
		
		return null;
	}

	public TreeNode findNodesInTree(TreeNode root, int val, List<Integer> path) {
		//path contains the backtraking nodes that belong to path
		if (root == null) return null;
		
		if (root.val == val) {
			path.add(root.val);
			return root;
		}
		
		TreeNode nl = findNodesInTree(root.left, val, path);
		if (nl != null) {
			path.add(root.val);
			return nl;
		}
		
		TreeNode nr = findNodesInTree(root.right, val, path);
		if (nr != null) { 
			path.add(root.val);
			return nr;
		}
		
		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

}
