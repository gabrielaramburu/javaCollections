package tree.binarytree.balance;

public class BalanceBST {

	public static void main(String[] args) {
		new BalanceBST().balanceBST(null);
		
	}

	public TreeNode balanceBST(TreeNode root) {
        return null;
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
