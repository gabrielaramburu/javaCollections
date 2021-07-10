package tree.binarytree.dfs;

/**
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * 
 * Input: root = [1,2,3], targetSum = 5 Output: false
 * 
 */
public class PathSum {
	private boolean hasPath = false;

	public static void main(String[] args) {
		PathSum hasPath = new PathSum();
		boolean result = hasPath.hasPathSum(hasPath.new TreeNode(5, hasPath.new TreeNode(4), hasPath.new TreeNode(3)),
				9);
		System.out.println("Result: " + result);
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root != null)
			return hasPathSum(root, targetSum, 0);
		else
			return false;
	}

	public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {

		if (root != null) {
			int current = currentSum + root.val;
			if (hasPath != true) hasPathSum(root.left, targetSum, current);
			if (hasPath != true) hasPathSum(root.right, targetSum, current);

			if (targetSum == current && root.left == null && root.right == null) {
				hasPath = true;
			}
		}
		return hasPath;
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
