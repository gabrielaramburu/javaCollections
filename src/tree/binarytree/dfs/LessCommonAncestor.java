package tree.binarytree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LessCommonAncestor {

	private boolean pWasFound;
	private boolean qWasFound;
	private List<Integer> pPath;
	private List<Integer> qPath;
	
	public static void main(String[] args) {
		LessCommonAncestor lessCommon = new LessCommonAncestor();
//		TreeNode root = lessCommon.new TreeNode(3, lessCommon.new TreeNode(5, lessCommon.new TreeNode(6), lessCommon.new TreeNode(2, lessCommon.new TreeNode(8), null)), 
//				lessCommon.new TreeNode(1));
//		
		TreeNode root = lessCommon.createTestCase(lessCommon.new TreeNode(0), 3000);
		System.out.println("Terminé de crear juego de prueba");
		lessCommon.lowestCommonAncestor(root, lessCommon.new TreeNode(2), lessCommon.new TreeNode(3));
	}

	private TreeNode createTestCase(TreeNode node, int value) {
		if (value > 0)  {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TreeNode newNode = new TreeNode(value);
			newNode.left =	createTestCase(newNode.left, value - 1);
			return newNode;
		}
		return null;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Character,List<Integer>> map = createEmptyHashMap();
        findNodesInTree(root, p.val, q.val, map);
        TreeNode result = findLessCommonAncestor();
        System.out.println("Salida " + result.val);
        return result;
   }
	
	private TreeNode findLessCommonAncestor() {
		List<Integer> longest;
		List<Integer> sortest;
		if (pPath.size() >= qPath.size()) {
			longest = pPath; sortest = qPath;
		} else {
			longest = qPath; sortest = pPath;
		}

		Map<Integer, Integer> longestPath = longest.stream().collect(Collectors.toMap(key -> key, Integer::new));
		
		for (int i = sortest.size() - 1; i >= 0 ; i--) {
			if (longestPath.get(sortest.get(i)) != null) {
				return new TreeNode(sortest.get(i));
			}
		}
		
		return null;
	}

	public void findNodesInTree(TreeNode root, int p, int q, Map<Character, List<Integer>> path) {
		if (root == null) return ;
		if (qWasFound && pWasFound)	return;

		Map<Character, List<Integer>> clonedPath = clonePath(path);
		if (!qWasFound) {
			updatePath(clonedPath, 'q', root.val);
		}
		
		if (!pWasFound) {
			updatePath(clonedPath, 'p', root.val);
		}

		if (root.val == p) {
			System.out.println("Encontre p");
			pWasFound = true;
			this.pPath = finalPath(clonedPath, 'p');
		}
		if (root.val == q) {
			System.out.println("Encontre q");
			qWasFound = true;
			this.qPath = finalPath(clonedPath, 'q');
		}

		findNodesInTree(root.left, p, q, clonedPath);
		findNodesInTree(root.right, p, q, clonedPath);
	}
	
	
	private List<Integer> finalPath(Map<Character, List<Integer>> clonedPath, char type) {
		return List.copyOf(clonedPath.get(type));
	}

	private List<Integer> updatePath(Map<Character, List<Integer>> path, char type, int value) {
		List<Integer> pathValues = path.get((Character)type);
		pathValues.add((Integer)value);
		path.put(Character.valueOf('q'), pathValues);
		return pathValues;
	}
	
	
	private Map<Character, List<Integer>> clonePath(Map<Character, List<Integer>> path) {
		
		Map<Character, List<Integer>> updatePath = new HashMap<Character, List<Integer>>();
		List<Integer> qPath = new ArrayList<Integer>();
		List<Integer> pPath = new ArrayList<Integer>();
		qPath.addAll(path.get('q'));
		pPath.addAll(path.get('p'));
		
		updatePath.put('q', qPath);
		updatePath.put('p', pPath);
		
		
		return updatePath;
	}

	
	public Map<Character, List<Integer>> createEmptyHashMap() {
		Map<Character, List<Integer>> hash = new HashMap<Character, List<Integer>>();
		hash.put('q', new ArrayList<Integer>());
		hash.put('p', new ArrayList<Integer>());
		return hash;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
		
	}

}
