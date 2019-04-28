
public class LowestCommonAncestorofBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
        	return root;
        } else {
        	if (left != null && right != null) {
        		return root;
        	}
        	return (left != null)? left: right;
        }
    }
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
