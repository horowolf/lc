import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {  
		if (root == null) {
			return new LinkedList<Integer>();
		}
		List<Integer> ans = new LinkedList<Integer>();
		LinkedList<TreeNode> backStep = new LinkedList<TreeNode>();
		TreeNode current = root;
		
		while (current != null) { //true
			ans.add(current.val);
			if (current.left != null) {
				if (current.right != null) {
					backStep.add(current); // or if current.right is not null?
				}
				current = current.left; 
			} else if (current.right != null) {
				current = current.right;
			} else { // no left and no right
				if (backStep.isEmpty()) {
					break;
				}
				current = backStep.removeLast().right;
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
