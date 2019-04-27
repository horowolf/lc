import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreefromInorderandPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode tree = null;
        if (inorder.length != postorder.length) {
        	System.out.println("length diff");
        	System.out.println(inorder[inorder.length - 1]);
        	System.out.println(postorder[inorder.length - 1]);
        }
        if (postorder.length == 0) {
        	return tree;
        }
        tree = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
        	return tree;
        }
        int rootLocation = 0;
		for (; rootLocation < inorder.length; rootLocation++) {
			if (inorder[rootLocation] == tree.val) {
				break;
			}
		}
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootLocation);
		int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootLocation);
		int[] rightInorder = Arrays.copyOfRange(inorder, rootLocation + 1, inorder.length);
		int[] rightPostorder = Arrays.copyOfRange(postorder, rootLocation, postorder.length - 1);
        
        TreeNode leftTree = buildTree(leftInorder, leftPostorder);
        TreeNode rightTree = buildTree(rightInorder, rightPostorder);        
		tree.left = leftTree;
		tree.right = rightTree;
		
		return tree;
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
