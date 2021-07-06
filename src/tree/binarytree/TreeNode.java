package tree.binarytree;

class TreeNode {
	 TreeNode left;
	 TreeNode right;
	 int value;
	
	TreeNode (int value, TreeNode ln, TreeNode rn) {
		this.left = ln;
		this.right = rn;
		this.value = value;
	}
	
	TreeNode (int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String leftStr = left!=null?this.left.value+"":"null";
		String rightStr = right!=null?this.right.value+"":"null";
		return "[left=" + leftStr + ", right=" + rightStr + ", value=" + value + "]";
	}
	
	
}
