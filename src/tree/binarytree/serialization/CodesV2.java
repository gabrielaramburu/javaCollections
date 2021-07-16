package tree.binarytree.serialization;

public class CodesV2 {
	private static final int NULL = 1111;

	public static void main(String[] args) {
		CodesV2 newCodec = new CodesV2();
		TreeNode root = newCodec.new TreeNode(3, newCodec.new TreeNode(2, newCodec.new TreeNode(3), null),
				newCodec.new TreeNode(4));
		
		newCodec.deserialize(newCodec.serialize(root));
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		root = convertToPerfectTree(root);
		return null;
	}

	private TreeNode convertToPerfectTree(TreeNode root) {
		int treeHeight = treeHeight(root, 0);
		return fullWithNull(root, treeHeight);
	}

	private TreeNode fullWithNull(TreeNode root, int level) {
		if (level == 0) return null; 
		
		TreeNode newRoot = new TreeNode(NULL);
		newRoot.left = fullWithNull(null, level - 1);
		newRoot.right = fullWithNull(null,  level -1);
		return newRoot;
	}

	private int treeHeight(TreeNode root, int level) {
		if (root == null) return level;
		
		return Math.max(treeHeight(root.left, level + 1), 	treeHeight(root.right, level + 1));
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode(int x, TreeNode l, TreeNode r) {
			this.val = x;
			this.left = l;
			this.right = r;
		}
	}
}
