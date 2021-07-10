package tree.binarytree.flatten.version2;

public class TreeNode {
	public TreeNode left;
	  public TreeNode right;
	  public ListNode value;
	  
	  TreeNode(ListNode value, TreeNode left, TreeNode right) {
	    this.value = value;
	    this.left = left;
	    this.right = right;
	  }
	  
	  TreeNode(ListNode value) {
	    this(value, null, null);
	  }
}
