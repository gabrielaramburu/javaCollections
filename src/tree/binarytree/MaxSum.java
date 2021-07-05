package tree.binarytree;
 class MaxSum {
	 private static enum Direction {LEFT, RIGHT};

	    /**
	     *      5
	     *    /   \
	     *  -22    11
	     *  / \    / \
	     * 9  50  9   2
	     */
	public static void main(String[] args) {
		
	}

	static int maxSum(TreeNode root) {
       int sumLeft =  new MaxSum().maxSumMethod(root, Direction.LEFT);
       int sumLeft =  new MaxSum().maxSumMethod(root, Direction.LEFT);
    }

	private int maxSumMethod(TreeNode node) {
		if (node.getLeftNode() == null) return node.getValue();
		int leftSum = maxSumMethod(node.getLeftNode());
		
		
		return 0;
	}
	
	
	
}
