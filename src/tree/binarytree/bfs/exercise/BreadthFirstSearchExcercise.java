package tree.binarytree.bfs.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: root = [1,2,3,4,5,6,7]
	Output: [1,#,2,3,#,4,5,6,7,#]
	Explanation: Given the above perfect binary tree (Figure A), 
	your function should populate each next pointer to point to its next right node, 
	just like in Figure B. The serialized output is in level order 
	as connected by the next pointers, with '#' signifying the end of each level.
 *
 */
public class BreadthFirstSearchExcercise {
	List<Node> nodeOfLevels = new ArrayList<BreadthFirstSearchExcercise.Node>();
	
	public static void main(String[] args) {
		BreadthFirstSearchExcercise instance = new BreadthFirstSearchExcercise();
		Node root = instance.new Node(1, 
				instance.new Node(2,instance.new Node(4,null,instance.new Node(7),null),instance.new Node(5),null),instance.new Node(3),null);
		new BreadthFirstSearchExcercise().connect(root);
	}
	
	public Node connect(Node root) {
        return breadthFirstSearch(root);
    }

	private Node breadthFirstSearch(Node root) {
		int treeHeight = treeHeight(root, 0);
		for (int level = 1; level < treeHeight + 1; level++) {
			traverseByLevel(root, level);
			connectNextPointer(root, nodeOfLevels);
			initializeListForNextLevel();
		}
		return root;
	}
	
	private void traverseByLevel(Node root, int level) {
		if (root != null) {
			if (level == 1) {
				nodeOfLevels.add(root);
			} else {
				traverseByLevel(root.left, level - 1);
				traverseByLevel(root.right, level - 1);
			}
		}
	}
	
	private void connectNextPointer(Node root, List<Node> nodeOfLevels) {
		nodeOfLevels.stream().forEach(item -> System.out.print(item.val + " next:" + item.next));
		System.out.println(" ");
		for (int idx = 0; idx < nodeOfLevels.size(); idx++) {
			Node node = nodeOfLevels.get(idx);
			if (node != null) {
				node.next = nextNodeOnList(idx, nodeOfLevels);
			}
		}
		System.out.println("After conection");
		nodeOfLevels.stream().forEach(item -> System.out.print(item.val + " next:" + item.next));
	}
	
	private Node nextNodeOnList(int idx, List<Node> nodeOfLevels) {
		if (idx == nodeOfLevels.size() - 1) return null;
		else return nodeOfLevels.get(idx + 1);
		
	}

	private void initializeListForNextLevel() {
		this.nodeOfLevels = new ArrayList<Node>();
		System.out.println("");
	}

	private int treeHeight(Node root, int maxLevel) {
		if (root == null) return maxLevel;
		return Math.max(treeHeight(root.left, maxLevel + 1), treeHeight(root.right, maxLevel + 1));
	}

	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
}
