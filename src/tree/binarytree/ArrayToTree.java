package tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToTree {
	private static final int INITIAL_LEVEL = 1;
	
	static TreeNode arrayToTree(int[] array) {
		
		if (array.length > 0) {
			List<TreeNode> rootNodosOfCurrentLevel = new ArrayList<TreeNode>();
			rootNodosOfCurrentLevel.add(new TreeNode(array[0]));
			TreeNode root = new ArrayToTree().arrayToTreeRecursive(array, rootNodosOfCurrentLevel, INITIAL_LEVEL).get(0);
			
			List<Integer> test = new ArrayList<Integer>();
			TreeNode.showInOrder(test, root);
			System.out.println("result " + test.toString());
			return root;
		}
		
		
		else return null;
	}

	List<TreeNode> arrayToTreeRecursive(int[] source, List<TreeNode> rootsNodosOfCurrentLevel, int currentLevel) {
		List<Integer> valuesToAssignOnNodesOfCurrentLevel = valuesOfCurrentLevel(source, currentLevel);	
		System.out.println(currentLevel +"->"+valuesToAssignOnNodesOfCurrentLevel);
		
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
		int numberOfNodesOfPreviuosLevels = 0;
		for (int level = 0; level < currentLevel; level++)
			numberOfNodesOfPreviuosLevels += Math.pow(2, level);
		
		return numberOfNodesOfPreviuosLevels;
	} 
	
	private int finalPosition (int currentLevel) {
		return initialPosition(currentLevel + 1) - 1;
	}

}
