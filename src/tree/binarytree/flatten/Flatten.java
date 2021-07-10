package tree.binarytree.flatten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 
 * For example, given the following list:

1 -> 4 -> 3 -> 6
 \       / \    \
  2     4   2    5

The method should return the following tree:

          1
       /     \
      2       3
     / \     /
    4   5   6   

 */
public class Flatten {
	private List<Integer> valuesFromInitialStructure = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3, new TreeNode(4), new TreeNode(2));
		TreeNode t4 = new TreeNode(6, null, new TreeNode(5));

		ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3, new ListNode(t4))));
		TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), null));
		
		TreeNode result = flatten(head);
	}

	static TreeNode flatten(ListNode head) {
		 new Flatten().builds(head);
		 return null;
	}
	
	private TreeNode builds(ListNode listNode) {
		travelListNode(listNode);
		
		List<Integer> treeInput = valuesFromInitialStructure.stream().distinct().sorted().collect(Collectors.toList());
		TreeNode newStructure = buildTreeFromList(treeInput, null, 0);
		return newStructure;
	}

	private void travelListNode(ListNode listNode) {
		if (listNode != null) {
			obtainValuesFromStructure(listNode.data);
			travelListNode(listNode.next);
		}
	}

	private void obtainValuesFromStructure(TreeNode data) {
		if (data != null) {
			storeValue(data.value);
			obtainValuesFromStructure(data.left);
			obtainValuesFromStructure(data.right);
		}

	}
	
	private void storeValue(Integer value) {
		valuesFromInitialStructure.add(value);
	}

	private TreeNode buildTreeFromList(List<Integer> input, TreeNode node, int idx) {
		
		if (idx < input.size()) {
			TreeNode newNode = new TreeNode(input.get(idx));
			node = newNode;
			node.left = buildTreeFromList(input, node.left, 2 * idx + 1);
			node.right = buildTreeFromList(input, node.right, 2 * idx + 2);
		}
		return node;
	}
}
