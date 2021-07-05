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
       int sum =  new MaxSum().maxSumMethod(root, 0, 0);
       System.out.println(sum);
       return sum;
	}

	private int maxSumMethod(TreeNode node, int totL, int totR) {
		System.out.println("l " + totL + " r " + totR+ " value " + node.getValue());
		if (node.getLeftNode() == null && node.getRightNode() == null) return node.getValue();
		
		int totLeft = 0, totRight = 0;
		if (node.getLeftNode() != null) {
			totLeft = maxSumMethod(node.getLeftNode(), totL + node.getValue(), totR);
			totLeft += node.getValue();
			System.out.println("totLeft" + totLeft);
		}
		if (node.getRightNode() !=null) {
			totRight = maxSumMethod(node.getRightNode(),totR, node.getValue() + totR);
			totRight += node.getValue();
			System.out.println("tot right " + totRight);
		}
		
		return totLeft > totRight?totLeft:totRight;
	}
	
	
	
}
