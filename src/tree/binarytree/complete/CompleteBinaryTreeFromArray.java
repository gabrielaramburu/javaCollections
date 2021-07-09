package tree.binarytree.complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CompleteBinaryTreeFromArray {
	
	private enum Leafs {LEFT, RIGHT}
	
	private List<Integer> output = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		int[] result = new CompleteBinaryTreeFromArray().apply(input);
		System.out.println(" resultado: " + result.toString());

	}

	public int[] apply(int[] input) {
		Integer[] inputAsInteger = completeMissingNodes(input);
		Node root = buildTree(inputAsInteger);
		traverseBFS(root, inputAsInteger.length);
		return output.stream().filter(item -> item != null?true:false).mapToInt(i -> i).toArray();
	}

	private Integer[] completeMissingNodes(int[] input) {
		int expectedNodes = input
		return null;
	}

	private Node buildTree(Integer[] input) {
		if (input.length == 1) 
			return new Node(input[0]);
		
		Node leftNode = buildTree(leafs(input, Leafs.LEFT));
		Node rightNode = buildTree(leafs(input, Leafs.RIGHT));
		
		Integer rootValue = searchRootNode(input);
		return new Node(rootValue).setLeft(leftNode).setRight(rightNode);
	}

	private Integer searchRootNode(Integer[] input) {
		int idxRoot = idxOfRootElement(input);
		System.out.println("Root element: " + input[idxRoot]);
		return input[idxRoot];
	}

	private int idxOfRootElement(Integer[] input) {
		return ((input.length - 1) / 2);
	}

	private Integer[] leafs(Integer[] input, Leafs leafsDirectionFromRoot) {
		Integer[] leafs;
		int rootIdx = idxOfRootElement(input);
		
		if (leafsDirectionFromRoot == Leafs.LEFT)
			leafs = Arrays.copyOfRange(input, 0, rootIdx);
		else
			leafs = Arrays.copyOfRange(input, rootIdx + 1, input.length);

		 Arrays.stream(leafs).forEach(val -> System.out.print(val + ", "));
		 System.out.println("");
		return leafs;
	}
	
	private void traverseBFS(Node root, int cantNodes) {
		int leves = (int)(Math.log(cantNodes) / Math.log(2));
		for (int level=1;level<=leves;level++) 
			showLevel(root, level);
	}

	private void showLevel(Node root, int level) {
		if (root != null) {
			if (level == 1) {
				output.add(root.getValue());
			} else  {
				showLevel(root.left, level -  1);
				showLevel(root.right, level -  1);
			}
		}
	}
	
	class Node {
		private Node left;
		private Node right;
		private Integer value;
		
		Node (Integer value) {
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

		public Integer getValue() {
			return value;
		}
	}

}
