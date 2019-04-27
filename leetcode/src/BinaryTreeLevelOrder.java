import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
        	return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> stream = new LinkedList<TreeNode>();
        stream.add(root);
        
        while (stream.size() > 0) {
        	LinkedList<TreeNode> buf = new LinkedList<TreeNode>();
        	List<Integer> writeStream = new LinkedList<Integer>();
        	
        	while (stream.size() > 0) {
        		TreeNode n = stream.pollFirst();
        		writeStream.add(n.val);
        		if (n.left != null) {
        			buf.add(n.left);
        		}
        		if (n.right != null) {
        			buf.add(n.right);
        		}
        	}
        	
        	result.add(writeStream);
        	stream = buf;
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
