package tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToTree {
	private static final int INITIAL_LEVEL = 1;
	
	static TreeNode arrayToTree(int[] array) {
		System.out.println(Arrays.toString(array));
		
		if (array.length > 0) {
			List<TreeNode> root = new ArrayList<TreeNode>();
			root.add(new TreeNode(array[0]));
			return new ArrayToTree().arrayToTreeRecursive(array, root, INITIAL_LEVEL).get(0);	
		}
			
		else return null;
	}
	
	List<TreeNode> arrayToTreeRecursive(int[] source, List<TreeNode> rootsNodosOfCurrentLevel, int currentLevel) {
		List<Integer> valuesToAssignOnNodesOfCurrentLevel = valuesOfCurrentLevel(source, currentLevel);	
		
		if (valuesToAssignOnNodesOfCurrentLevel.isEmpty()) return rootsNodosOfCurrentLevel;
			
		List<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
		
		for (int i = 0, j = 0; i < valuesToAssignOnNodesOfCurrentLevel.size();i+=2, j++) {
			TreeNode newLeft = new TreeNode(valuesToAssignOnNodesOfCurrentLevel.get(i));
			rootsNodosOfCurrentLevel.get(j).left = newLeft;
			currentLevelNodes.add(newLeft);
			
			if (i+1 < valuesToAssignOnNodesOfCurrentLevel.size()) {
				TreeNode newRigh = new TreeNode(valuesToAssignOnNodesOfCurrentLevel.get(i+1));
				rootsNodosOfCurrentLevel.get(j).right = newRigh;						
				currentLevelNodes.add(newRigh);	
			}
		}
			
		arrayToTreeRecursive(source, currentLevelNodes, currentLevel + 1);

		return rootsNodosOfCurrentLevel;
	}

	private List<Integer> valuesOfCurrentLevel(int[] source, int currentLevel) {
		int initPos = initialPosition(currentLevel);
		int finalPos = finalPosition(currentLevel);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = initPos; i < source.length && i <= finalPos; i++) {
			list.add(source[i]);
		}
		return list;
	}

	private int initialPosition(int currentLevel) {
		int initPos = 1;
		for (int level = 1; level < currentLevel; level++)
			initPos += level * 2;
		
		return initPos;
	} 
	
	private int finalPosition (int currentLevel) {
		return initialPosition(currentLevel + 1) - 1;
	}

}
