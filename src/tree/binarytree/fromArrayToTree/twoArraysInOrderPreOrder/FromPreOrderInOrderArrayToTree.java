package tree.binarytree.fromArrayToTree.twoArraysInOrderPreOrder;

import java.util.Arrays;

/**
 * 	Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	Output: [3,9,20,null,null,15,7]
	
	https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class FromPreOrderInOrderArrayToTree {

	public static void main(String[] args) {
		int[] preOrder = { 3, 9, 20,15, 7 };
		int[] inOrder = {9,3,15,20, 7};
		new FromPreOrderInOrderArrayToTree().buildTree(preOrder, inOrder);
		
		System.out.println("****");
		int[] preOrder2 = { 1, 2, 3 };
		int[] inOrder2 = {3, 2, 1};
		new FromPreOrderInOrderArrayToTree().buildTree(preOrder2, inOrder2);
		
		System.out.println("****");
		int[] preOrder3 = { 7,-10,-4,3,-1,2,-8,11 };
		int[] inOrder3 =  {-4,-10,3,-1,7,11,-8,2};
		new FromPreOrderInOrderArrayToTree().buildTree(preOrder3, inOrder3);
		
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length == 0) return null;
		if (inorder.length == 1) return new TreeNode(inorder[0]);

		int rootValue = preorder[0];

		int idxRoot = idxRoot(inorder, rootValue);
		int[] inOrderLeftValues = Arrays.copyOfRange(inorder, 0, idxRoot);
		int[] inOrderRightValues = Arrays.copyOfRange(inorder, idxRoot + 1, inorder.length);
		
		int[] preOrderLeftValues = Arrays.copyOfRange(preorder, 1, inOrderLeftValues.length + 1);

        int from = preOrderLeftValues.length  + 1;
        int[] preOrderRightValues = Arrays.copyOfRange(preorder, from, from + inOrderRightValues.length);


		TreeNode node = new TreeNode(rootValue);
		node.left = buildTree(preOrderLeftValues, inOrderLeftValues);
		node.right = buildTree(preOrderRightValues, inOrderRightValues);

		return node;
	}

	private int idxRoot(int[] intOrder, int rootValue) {
		for (int i = 0; i < intOrder.length; i++) {
			if (intOrder[i] == rootValue) {
				return i;
			}
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
