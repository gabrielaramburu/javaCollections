package tree.binarytree.fromArrayToTree.twoArraysInOrderPostOrder;

import java.util.Arrays;
import java.util.Map;

/**
 *Given two integer arrays inorder and postorder where inorder 
 *is the inorder traversal of a binary tree and postorder is the postorder traversal 
 *of the same tree, construct and return the binary tree. 
 *
 *	Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	Output: [3,9,20,null,null,15,7]
	
	The key point that was hard to me to understand is that from inOrder array representation on a tree I can't build back the
	original tree because there are at least three differents ways to create e tree that gives the same output when its traverese by inOrder
	
	The same idea apply to pre and post order.
	
	https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	
 */
public class FromPostOrderInOrderArrayToTree {
	
	public static void main(String[] args) {
//		int[] inOrder = {9, 3, 15, 20, 7};
//		int[] postOrder = {9,15, 7, 20, 3};
//		int[] inOrder = {1, 2, 3, 4};
//		int[] postOrder = {2, 1, 4, 3};
//		new FromArrayToTree().builTree(inOrder, postOrder);
	}
	

	public TreeNode builTree(int[] inOrder, int[] postOrder) {
		if (inOrder.length == 0) return null;
		if (inOrder.length == 1) return new TreeNode(inOrder[0]);
		
		int rootValue = postOrder[postOrder.length - 1];
		int rootIdx = searchRootIdx(inOrder, rootValue);
		
		int[] inOrderleftValues = Arrays.copyOfRange(inOrder, 0, rootIdx);
		int[] inOrderRightValues = Arrays.copyOfRange(inOrder, rootIdx + 1, inOrder.length);
		
		int idxStartRightValues = (postOrder.length - 1) - inOrderRightValues.length;
		int[] postOrderLeftValues = Arrays.copyOfRange(postOrder, 0, idxStartRightValues);
		int[] postOrderRightValues = Arrays.copyOfRange(postOrder, idxStartRightValues, postOrder.length - 1);
		
		
		TreeNode root = new TreeNode(rootValue);
		root.left = builTree(inOrderleftValues, postOrderLeftValues);
		root.right = builTree(inOrderRightValues, postOrderRightValues);
		
		return root;
	}
	
	private int searchRootIdx(int[] inOrder, int rootValue) {
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == rootValue) return i;
		}
		return -1;
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
