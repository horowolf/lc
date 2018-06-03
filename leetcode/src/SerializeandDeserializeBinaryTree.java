import java.util.LinkedList;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) { // Q 297
    	String ans = "[";
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        String tempNull = "";
        
        if (root != null) {
        	TreeNode current = null;
        	while (list.size() > 0) {
        		current = list.poll(); // get first + remove
        		
        		if (current != null) {
        			if (current.left != null) {
            			list.add(current.left);
            		} else {
            			list.add(null);
            		}
            		if (current.right != null) {
            			list.add(current.right);
            		} else {
            			list.add(null);
            		}
        			ans = ans + tempNull + String.valueOf(current.val) + ",";
        			tempNull = "";
        		} else {
        			tempNull = tempNull + "null,";
        		}
        		
            }
        }
        
        if (ans.charAt(ans.length() - 1) == ',') {
        	ans = ans.substring(0, ans.length() - 1);
        }
        
        ans = ans + "]";
    	return ans;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	TreeNode root = null;
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    	data = data.substring(1, data.length() - 1);
    	String[] dataList = data.split(",");
    	int i = 0;
    	
    	try {
    		int v = Integer.valueOf(dataList[i]);
    		root = new TreeNode(v);
    		list.add(root);
    	} catch (NumberFormatException e) {
			return root;
		}
    	
    	TreeNode current;
    	while (list.size() > 0) {
    		// get head of list
    		current = list.poll();
    		// add left (check i still in dataList range first)
    		i++;
    		if (i < dataList.length) {
    			try {
        			int v = Integer.valueOf(dataList[i]);
        			TreeNode n = new TreeNode(v);
        			current.left = n;
        			list.add(n);
        		} catch (NumberFormatException e) {
        			//list.add(null);
        		}
    		}
    		// add right (check i still in dataList range first)
    		i++;
    		if (i < dataList.length) {
    			try {
        			int v = Integer.valueOf(dataList[i]);
        			TreeNode n = new TreeNode(v);
        			current.right = n;
        			list.add(n);
        		} catch (NumberFormatException e) {
        			//list.add(null);
        		}
    		}
    	}
    	
        return root;
    }
    
    static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
