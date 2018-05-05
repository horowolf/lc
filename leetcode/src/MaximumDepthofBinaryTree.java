


public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
        int left = 0, right = 0;
		
		if (root.left != null) {
			left = maxDepth(root.left);
		}
		if (root.right != null) {
			right = maxDepth(root.right);
		}
		
		if (left > right) {
			return left + 1;
		}
		return right + 1;
		
    }

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}