package tree.binarytree;

public class PerfectTree {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(-22, new TreeNode(9),new TreeNode(50));
        TreeNode right = new TreeNode(11, new TreeNode(9),new TreeNode(94));
        TreeNode root = new TreeNode(5, left, right);
        
        boolean result = new PerfectTree().isPerfect(null);
        System.out.println("It is perfect:" + result);
	}
	
	public boolean isPerfect(TreeNode node) {
		int treeHeight = treeHeight(node, 0);
		return isPerfect(node, treeHeight, 0);
	}

	private boolean isPerfect(TreeNode node, int treeHeight, int currentTreeLevel) {
		if (node == null) return true;
		if (isALeaf(node) && !lastLevel(treeHeight, currentTreeLevel)) return false;
		if (!isALeaf(node) && hasOnlyOneChild(node)) return false;
			
		boolean result = true;
		result = isPerfect(node.left, treeHeight, currentTreeLevel + 1);
		if (result) result = isPerfect(node.right, treeHeight, currentTreeLevel + 1);
		return result;
	}

	
	private boolean hasOnlyOneChild(TreeNode node) {
		return (node.left == null ^ node.right == null)?true:false;
	}

	private boolean lastLevel(int treeHeight, int currentTreeLevel) {
		return treeHeight == currentTreeLevel?true:false;
	}

	private boolean isALeaf(TreeNode node) {
		return node.left==null && node.right==null?true:false;
	}
	
	private int treeHeight(TreeNode node, int level) {
		if (node == null) return level;
		if (isALeaf(node)) return level;
		
		int maxLevelLeft = treeHeight(node.left, level + 1);
		int maxLevelRight = treeHeight(node.right, level + 1);
		return maxLevelLeft >= maxLevelRight?maxLevelLeft:maxLevelRight;
	}
}
