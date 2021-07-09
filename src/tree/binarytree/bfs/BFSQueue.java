package tree.binarytree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BFSQueue {

	public static void main(String[] args) {
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));

		Node root = new Node(new Node(null, new Node(null, null, 4), 2),
				new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1);
		
		treeByLevels(root);
	}

	public static List<Integer> treeByLevels(Node node) {
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Integer> result = new ArrayList<Integer>();
		
		if (node != null) queue.add(node);
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			
			System.out.println("node " + currentNode.value);
			result.add(currentNode.value);
			
			if (currentNode.left != null) queue.add(currentNode.left);
			if (currentNode.right != null) queue.add(currentNode.right);
			
		}
		return result;
	}

}
