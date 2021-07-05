package tree.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    

    /**
     *      5
     *    /   \
     *  -22    11
     *  / \    / \
     * 9  50  9   2
     */
    @Test
    public void maxSumInPerfectTree() {
  
        TreeNode left = new TreeNode(new TreeNode(9),new TreeNode(50),  -22);
        TreeNode right = new TreeNode(new TreeNode(9),new TreeNode(2),  11);
        TreeNode root = new TreeNode(left, right, 5);
        assertEquals(MaxSum.maxSum(root), 33);
    }
}