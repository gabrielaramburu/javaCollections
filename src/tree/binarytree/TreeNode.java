package tree.binarytree;

class TreeNode {
	private TreeNode leftNode;
	private TreeNode rightNode;
	private int value;
	
	TreeNode (TreeNode ln, TreeNode rn, int value) {
		this.leftNode = ln;
		this.rightNode = rn;
		this.value = value;
	}
	
	TreeNode (int value) {
		this.value = value;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public int getValue() {
		return value;
	}
	
	
}
