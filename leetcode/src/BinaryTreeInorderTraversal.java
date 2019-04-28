import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return result;
		}
		TreeNode node = root;
		while (node != null) {
			if (node.left != null) {
				stack.add(node);
				node = node.left;
				continue;
			}
			while (true) {
				result.add(node.val);
				if (node.right != null) {
					node = node.right;
					break;
				}
				if (stack.isEmpty()) {
					node = null;
					break;
				}
				node = stack.pop();
			}
		}
		
		return result;
    }
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
