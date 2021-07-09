package tree.binarytree.complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CompleteBinaryTreeFromArray {
	
	private enum Leafs {LEFT, RIGHT}
	
	private List<Integer> output = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		int[] result = new CompleteBinaryTreeFromArray().apply(input);
		System.out.println("Result: " + Arrays.toString(result));
	}

	public int[] apply(int[] input) {
		Integer[] inputAsInteger = completeMissingNodes(input);
		
		Node root = buildTree(inputAsInteger);
		traverseBFS(root, inputAsInteger.length);
		return output.stream().filter(item -> item != null?true:false).mapToInt(i -> i).toArray();
	}

	/* Transform the input array in a Perfect Binary tree representation */ 
	private Integer[] completeMissingNodes(int[] input) {
		List<Integer> perfectTree = Arrays.stream(input).boxed().collect(Collectors.toList());
		
		int treeLevel = treeLevel(input.length);
		int expectedNodes = (int)Math.pow(2, treeLevel + 1) - 1;
		
		int missingNodes = expectedNodes - input.length;
		for (int i=perfectTree.size(); i >=0; i--) {
			if (missingNodes>0) {
				perfectTree.add(i, null);
				missingNodes--;
			} else break;
		}
		System.out.println("conversion.");
		perfectTree.stream().forEach(val -> System.out.print(val + ", "));
		return perfectTree.toArray(Integer[]::new);
	}

	/* The input array follows the pattern: left parent right  */
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
	
	private int treeLevel (int cantNodes) {
		return (int)(Math.log(cantNodes) / Math.log(2));
	}
	
	private void traverseBFS(Node root, int cantNodes) {
		for (int level=1;level<=treeLevel(cantNodes) + 1;level++) 
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
