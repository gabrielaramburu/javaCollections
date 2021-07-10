package tree.binarytree.flatten;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int value;

	TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	TreeNode(int value) {
		this(value, null, null);
	}
}
