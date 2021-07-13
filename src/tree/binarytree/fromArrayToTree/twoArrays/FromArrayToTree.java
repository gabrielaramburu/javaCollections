package tree.binarytree.fromArrayToTree.twoArrays;

import java.util.Arrays;

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
	
	
 */
public class FromArrayToTree {

	public static void main(String[] args) {
//		int[] inOrder = {9, 3, 15, 20, 7};
//		int[] postOrder = {9,15, 7, 20, 3};
		int[] inOrder = {2, 3, 1};
		int[] postOrder = {3, 2, 1};
		new FromArrayToTree().builTree(inOrder, postOrder);
	}

	public TreeNode builTree(int[] inOrder, int[] postOrder) {
		if (inOrder.length == 0) return null;
		if (inOrder.length == 1) return new TreeNode(inOrder[0]);
		
		int rootValue = postOrder[postOrder.length - 1];
		int rootIdx = searchRootIdx(inOrder, rootValue);
		
		System.out.println("Root value inicial:" + rootValue);
		
		int[] leftValues = Arrays.copyOfRange(inOrder, 0, rootIdx);
		int[] rightValues = Arrays.copyOfRange(inOrder, rootIdx + 1, inOrder.length);
		
		System.out.println(Arrays.toString(leftValues));
		System.out.println(Arrays.toString(rightValues));		
		
		TreeNode root = new TreeNode(rootValue);
		root.left = buildFromArrays(leftValues);
		root.right = buildFromArrays(rightValues);
		
		return root;
	}
	
	private int searchRootIdx(int[] inOrder, int rootValue) {
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == rootValue) return i;
		}
		return -1;
	}

	public TreeNode buildFromArrays(int[] values) {
		if (values.length == 0) return null;
		if (values.length == 1) return new TreeNode(values[0]);
		
		int[] leftValues = Arrays.copyOfRange(values, 0, (values.length / 2));
		int[] rightValues = Arrays.copyOfRange(values, (values.length / 2) + 1, values.length);
		int rootValue = values[values.length / 2];
		
		System.out.println("root value " + rootValue);
		TreeNode root = new TreeNode(rootValue);
		root.left = buildFromArrays(leftValues);
		root.right = buildFromArrays(rightValues);
		
		return root;
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
