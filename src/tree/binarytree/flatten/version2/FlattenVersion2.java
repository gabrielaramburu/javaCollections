package tree.binarytree.flatten.version2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/*
 * For example, given the following tree:

    17->1
   /  \
  3    1
 /    / \
2    16  7->3

The method should return 1 -> 2 -> 3 -> 7 -> 16 -> 17.
 * */


public class FlattenVersion2 {
	private List<Integer> flattenValues = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		 ListNode l1 = new ListNode(17, new ListNode(1));
		    ListNode l2 = new ListNode(3);
		    ListNode l3 = new ListNode(1);
		    ListNode l4 = new ListNode(2);
		    ListNode l5 = new ListNode(16);
		    ListNode l6 = new ListNode(7, new ListNode(3));
		    TreeNode root = new TreeNode(l1, new TreeNode(l2, new TreeNode(l4), null), new TreeNode(l3, new TreeNode(l5), new TreeNode(l6)));
		    
		    ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(16, new ListNode(17))))));
		    ListNode result = flatten(null);
	}
	
	static ListNode flatten(TreeNode head) {
		return new FlattenVersion2().builds(head);
	}
	
	private ListNode builds(TreeNode head) {
		traverseTreeDFS(head);
		List<Integer> sortedDistinctValues = flattenValues.stream().distinct().sorted().collect(Collectors.toList());
		return buildListNode(sortedDistinctValues, 0);
	}
	
	private ListNode buildListNode(List<Integer> sortedDistinctValues, int idx) {
		if (idx < sortedDistinctValues.size()) {
			ListNode newListNode = new ListNode(sortedDistinctValues.get(idx), buildListNode(sortedDistinctValues, idx + 1));
			return newListNode;
		} else return null;
	}

	private void traverseTreeDFS(TreeNode root) {
		if (root != null) {
			List<Integer> values;
			traverseList(root.value);
			traverseTreeDFS(root.left);
			traverseTreeDFS(root.right);
		}
	}

	private void traverseList(ListNode listNode) {
		if (listNode != null) {
			traverseList(listNode.next);
			flattenValues.add(listNode.data);
		}
	}

}
