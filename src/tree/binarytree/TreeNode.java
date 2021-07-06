package tree.binarytree;

import java.util.List;

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
	
	public static void showInOrder(List<Integer> values, TreeNode node) {
		if (node != null) {
			TreeNode.showInOrder(values, node.left);
			values.add(node.value);
			TreeNode.showInOrder(values, node.right);
		}
	}
	
	
}
