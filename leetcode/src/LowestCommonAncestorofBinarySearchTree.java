import java.util.LinkedList;

public class LowestCommonAncestorofBinarySearchTree {
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> pList = new LinkedList<TreeNode>();
		LinkedList<TreeNode> qList = new LinkedList<TreeNode>();
		TreeNode buf = root;
		while (true) {
			pList.add(buf);
			if (buf.val == p.val) {
				break;
			}
			if (buf.val > p.val) {
				buf = buf.left;
			} else {
				buf = buf.right;
			}
		}
		buf = root;
		while (true) {
			qList.add(buf);
			if (buf.val == q.val) {
				break;
			}
			if (buf.val > q.val) {
				buf = buf.left;
			} else {
				buf = buf.right;
			}
		}
		
		do {
			buf = pList.pollFirst();
			qList.pollFirst();
			if (pList.isEmpty() || qList.isEmpty()) {
				break;
			}
			if (pList.getFirst() != qList.getFirst()) {
				break;
			}
		} while (true);
		
		return buf;
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
