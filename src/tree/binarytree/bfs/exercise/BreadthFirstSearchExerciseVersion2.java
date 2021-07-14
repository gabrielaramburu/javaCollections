package tree.binarytree.bfs.exercise;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchExerciseVersion2 {
	List<Node> levelNodes = new ArrayList<Node>();

	public static void main(String[] args) {
		BreadthFirstSearchExerciseVersion2 instance = new BreadthFirstSearchExerciseVersion2();
		Node root = instance.new Node(1,
				instance.new Node(2,instance.new Node(4,null,null, null),instance.new Node(5,null,null, null), null), 
				instance.new Node(3,null,instance.new Node(7,null,null, null),null), null);
		
		
		new BreadthFirstSearchExerciseVersion2().connect(root);
	}

	
	public Node connect(Node root) {
		int treeHeight = treeHeight(root, 0);
		for (int level = 1; level <= treeHeight; level++) {
			traverseBFS(root, level);
			connectNodes();
			levelNodes = new ArrayList<Node>();
		}
		
		return root;
	}

	public void traverseBFS(Node node, int level) {
		if (node != null) {
			if (level == 1) {
				levelNodes.add(node);
			} else {
				traverseBFS(node.left, level - 1);
				traverseBFS(node.right, level - 1);
			}
		}
	}

	public void connectNodes() {
	       for (int i = 0; i < levelNodes.size(); i++) {
	           if (levelNodes.get(i) != null) {
	               for (int aux = i + 1; aux < levelNodes.size(); aux++) {
	                   if (levelNodes.get(aux) != null) {
	                       levelNodes.get(i).next = levelNodes.get(aux);
	                       break;
	                   }
	                   i = aux;
	               }
	           }
	       }
	    }

	public int treeHeight(Node root, int level) {
		if (root == null) return level;
		return Math.max(treeHeight(root.left, level + 1), treeHeight(root.right, level + 1));
	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}
		
		public Integer getNextValue() {
			if (this.next != null) return this.next.val;
			return null;
		}
		
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

}
