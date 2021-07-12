package tree.binarytree.balance;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
	private List<Integer> valuesFromTree = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		new BalanceBST().balanceBST(new BalanceBST().buildTestCase());

	}

	public TreeNode buildTestCase() {
		TreeNode root = new TreeNode(1,	null ,new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, null))));
		//TreeNode root = new TreeNode(4,	new TreeNode(3 , new TreeNode(2, new TreeNode(1, null, null), null), null), null);
		return root;
	}
	
	public TreeNode balanceBST(TreeNode root) {
		inOrderTraversal(root);
		TreeNode result = buildBalancedTree(valuesFromTree);
		return result;
	}

	private TreeNode buildBalancedTree(List<Integer> values){
	        if (values.size() == 0) return null;
	        if (values.size() == 1) return new TreeNode(values.get(0));
	        
	        List<Integer> leftValues = values.subList(0, values.size() / 2);
	        List<Integer> rightValues = values.subList(values.size() / 2, values.size());
	        int rootValue = rightValues.get(0);
	        rightValues = deleteRootElement(rightValues);
	        
	        TreeNode newNode = new TreeNode(rootValue); //for evens size list the right size is bigger than the left one
	        newNode.left = buildBalancedTree(leftValues);
	        newNode.right = buildBalancedTree(rightValues);
	        return newNode;
	    }

	private List<Integer> deleteRootElement(List<Integer> rightValues) {
		//the easyest approach to use remove does not work over recursion
		if (rightValues.size() == 1) return new ArrayList<Integer>();
		else return rightValues.subList(1, rightValues.size());
	}

	private void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			valuesFromTree.add(root.val);
			inOrderTraversal(root.right);
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
