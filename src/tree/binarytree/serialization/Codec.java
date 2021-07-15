package tree.binarytree.serialization;

import java.util.Arrays;

public class Codec {

	public static void main(String[] args) {

	}
	
	  StringBuilder serialInfo = new StringBuilder();
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        inOrderTraversal(root);
	        serialInfo.append("#");
	        postOrderTraversal(root);
	        return serialInfo.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] splitedData = data.split("#");
	        int[] inOrderNodesValues = createNodeValues(splitedData[0]);
	        int[] postOrderNodesValues = createNodeValues(splitedData[1]);    
	        
	        TreeNode root = buildTree(inOrderNodesValues, postOrderNodesValues);
	        return root;
	    }
	    
	    private TreeNode buildTree(int[] inOrder, int[] postOrder) {
	        int rootValue = postOrder[postOrder.length - 1];
	        
	        int rootIdx = findRootIdx(inOrder, rootValue);
	        int[] leftInOrder = Arrays.copyOfRange(inOrder, inOrder[0], inOrder[rootIdx] + 1);
	        int[] rigthInOrder = Arrays.copyOfRange(inOrder, leftInOrder.length + 1, inOrder.length);
	        
	        int[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, leftInOrder.length);
	        int[] rigthPostOrder = Arrays.copyOfRange(postOrder, leftInOrder.length, rigthInOrder.length);
	        
	        TreeNode node = new TreeNode(rootValue);
	        node.left = buildTree(leftInOrder, leftPostOrder);
	        node.right = buildTree(rigthInOrder, rigthPostOrder);
	        
	        return node;
	    }
	    
	    private int findRootIdx (int[] inOrder, int rootValue) {
	        for (int i = 0; i < inOrder.length; i++) {
	            if (inOrder[i] == rootValue) return i;
	        }
	        return -1;
	    }
	    
	    private int[] createNodeValues (String data) {
	        String[] values = data.split(",");
	        return Arrays.stream(values).mapToInt(val -> Integer.valueOf(val)).toArray();
	    }
	    
	    private void inOrderTraversal(TreeNode root) {
	        if (root != null) {
	            inOrderTraversal(root.left);
	            serialInfo.append(root.val);
	            serialInfo.append(",");
	            inOrderTraversal(root.right);    
	        }
	    }
	    
	    private void postOrderTraversal(TreeNode root) {
	        if (root != null) {
	            postOrderTraversal(root.left);
	            postOrderTraversal(root.right);
	            serialInfo.append(root.val);
	            serialInfo.append(",");
	        }
	    }
	    
	    public class TreeNode {
	    	      int val;
	    	      TreeNode left;
	    	      TreeNode right;
	    	      TreeNode(int x) { val = x; }
	    	  }

}
