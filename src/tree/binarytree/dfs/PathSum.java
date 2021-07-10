package tree.binarytree.dfs;

/**
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * 
 * Input: root = [1,2,3], targetSum = 5 Output: false
 *
 * 
 */
public class PathSum {
	private boolean hasPath = false;
	
	public static void main(String[] args) {
		PathSum hasPath = new PathSum();
//		boolean result = hasPath.hasPathSum(
//				hasPath.new TreeNode(5, hasPath.new TreeNode(4), hasPath.new TreeNode(3))
//				,9);
//				
//		boolean result1 = hasPath.hasPathSum(
//				null	
//				,0);
//		System.out.println("Result: " + result1);
		
		boolean result2 = hasPath.hasPathSum(
				hasPath.new TreeNode(1, hasPath.new TreeNode(2), null)	
				,1);
		System.out.println("Result: " + result2);
		
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root != null) return hasPathSum(root, targetSum, 0);
		else return false;
	}
	
	public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {
		System.out.println("Entro con targent " + targetSum + " y current " + currentSum);
		
		if (root == null) {
			System.out.println("curre sum " + currentSum);
			if (targetSum == currentSum) hasPath = true;
		} else {
			if (hasPath != true) hasPathSum(root.left, targetSum, currentSum + root.val);
			if (hasPath != true) hasPathSum(root.right,targetSum, currentSum + root.val);
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
