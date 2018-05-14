
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int ans = getH(root);
		if (ans >= 0) {
			return true;
		}
        return false;
    }
	
	private static int getH(TreeNode root) {
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = getH(root.left);
		}
		
		if (root.right != null) {
			right = getH(root.right);
		}
		
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(left, right) + 1;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}

