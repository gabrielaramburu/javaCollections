package tree.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxSumTest {
    

    /**
     *      5
     *    /   \
     *  -22    11
     *  / \    / \
     * 9  50  9   2
     */
    @Test
    public void maxSumInPerfectTree() {
  
        TreeNode left = new TreeNode(-22, new TreeNode(9),new TreeNode(50));
        TreeNode right = new TreeNode(11, new TreeNode(9),new TreeNode(2));
        TreeNode root = new TreeNode(5, left, right);
        assertEquals(MaxSum.maxSum(root), 33);
    }
    
    @Test
    public void maxSumInNullTree() {
        TreeNode root = null;
        assertEquals(MaxSum.maxSum(root), 0);
    }
}