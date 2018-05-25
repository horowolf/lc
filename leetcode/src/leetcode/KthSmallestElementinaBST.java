package leetcode;

public class KthSmallestElementinaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int kthSmallest(TreeNode root, int k) {
        int counted = 0;
        if (root.left != null) {
        	int l = kthSmallest(root.left, k);
        	if (l >= 0) {
            	return l;
            }
        	counted += l;
        }
        if (k + counted == 1) {
        	return root.val;
        }
        counted -= 1;
        
        if (root.right != null) {
        	int r = kthSmallest(root.right, k + counted);
        	if (r >= 0) {
        		return r;
        	}
        	counted += r;
        }
        
		return counted;
    }

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}