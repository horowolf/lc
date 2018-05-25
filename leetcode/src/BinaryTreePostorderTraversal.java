import java.util.LinkedList;
import java.util.List;


public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> postorderTraversal(TreeNode root) {  
		if (root == null) {
			return new LinkedList<Integer>();
		}
		List<Integer> ans = new LinkedList<Integer>();
		LinkedList<TreeNode> backStep = new LinkedList<TreeNode>();
		TreeNode current = root;
		
		while (current != null) { //true
			
			if (current.left != null) {
				backStep.add(current);
				current = current.left; 
			} else if (current.right != null) {
				backStep.add(current);
				current = current.right;
			} else { // no left and no right
				ans.add(current.val);
				if (backStep.isEmpty()) {
					break;
				}
				current = backStep.removeLast();
				if (current.left != null) {
					current.left = null;
				} else if (current.right != null) {
					current.right = null;
				}
				//current.left = null;
			}
			
			// if no left and no right, pop backStep if size > 0 and goRight
			
			// if backStep has nothing to pop, break!
		}
		
		return ans;
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
