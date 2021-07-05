package tree.binarytree;

class MaxSum {

	    /**
	     *      5
	     *    /   \
	     *  -22    11
	     *  / \    / \
	     * 9  50  9   2
	     */

	static int maxSum(TreeNode root) {
       int sum =  new MaxSum().maxSumMethod(root);
       System.out.println(sum);
       return sum;
	}

	private int maxSumMethod(TreeNode node) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) return node.value;
		
		int totLeft = 0, totRight = 0;
		if (node.left != null) {
			totLeft = maxSumMethod(node.left);
			totLeft += node.value;
		}
		if (node.right !=null) {
			totRight = maxSumMethod(node.right);
			totRight += node.value;
		}
		
		return totLeft > totRight?totLeft:totRight;
	}
	
	
}
