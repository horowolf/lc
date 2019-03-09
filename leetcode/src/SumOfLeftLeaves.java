import java.util.LinkedList;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfLeftLeaves(null));
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return walkThrough(root, 0);
    }
	
	public static int walkThrough(TreeNode root, int keep) {
		int result = keep;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				result = root.left.val + result;
			}
			result = walkThrough(root.left, result);
		}
		if (root.right != null) {
			result = walkThrough(root.right, result);
		}
		
		return result;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
