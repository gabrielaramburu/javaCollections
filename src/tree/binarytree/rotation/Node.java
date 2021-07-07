package tree.binarytree.rotation;

public class Node {
	private Node left;
	private Node right;
	private int value;
	
	Node (int value) {
		this.value = value;
	}
	
	public Node setLeft(Node left) {
		this.left = left;
		return this;
	}
	public Node setRight(Node right) {
		this.right = right;
		return this;
	}
	
	
    public Node rotateRight(Node root) {
        return root; // Replace with your solution
    }

    public Node rotateLeft(Node root) {
        return root; // Replace with your solution
    }
   
	
}
