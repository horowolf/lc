
public class CountUnivalueSubtrees {
	static int count = 0;
	public int countUnivalueSubtrees(TreeNode root) {
		check(root);
		return count;
	}
	
	private boolean check(TreeNode subtree) {
		if (subtree.left == null && subtree.right == null) {
			count ++;
			return true;
		}
		if (subtree.left != null) {
			if (check(subtree.left)) {
				if (subtree.val != subtree.left.val) {
					return false;
				}
			} else {
				return false;
			}
		}
		if (subtree.right != null) {
			if (check(subtree.right)) {
				if (subtree.val != subtree.right.val) {
					return false;
				}
			} else {
				return false;
			}
		}
		count ++;
		return true;
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
