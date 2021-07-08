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
	
	
    public static Node rotateRight(Node root) {
    	if (root.left == null) return root;
    	Node oldRoot = root;
    	root = root.left;
    	Node auxRight = root.right;
    	root.right = oldRoot;
    	oldRoot.left = auxRight;
        return root;
    }

    public static Node rotateLeft(Node root) {
    	if (root.right == null) return root;
    	Node oldRoot = root;
    	root = root.right;
    	Node auxLeft = root.left;
    	root.left = oldRoot;
    	oldRoot.right = auxLeft;
        return root; 
    }
   
    
    @Override
	public boolean equals(Object obj) {
    	if (obj != null) return this.value == ((Node)obj).value;
    	else return false;
	}

	public static void showPreOrder(Node node) {
		if (node != null) {
			System.out.print(node.value + ", ");
			Node.showPreOrder(node.left);
			Node.showPreOrder(node.right);
		}
	}
	
    
}
