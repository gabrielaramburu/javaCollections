package tree.binarytree;

class TreeNode {
	 TreeNode left;
	 TreeNode right;
	 int value;
	
	TreeNode (TreeNode ln, TreeNode rn, int value) {
		this.left = ln;
		this.right = rn;
		this.value = value;
	}
	
	TreeNode (int value) {
		this.value = value;
	}
	
}
