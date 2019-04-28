
public class CountUnivalueSubtrees {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(5);
		l1.left = new TreeNode(5);
		l1.right = new TreeNode(5);
		r1.right = new TreeNode(5);
		root.left = l1;
		root.right = r1;
		
		System.out.println(countUnivalueSubtrees(root));
	}
	
	
	static int count = 0;
	public static int countUnivalueSubtrees(TreeNode root) {
		check(root);
		return count;
	}
	
	private static boolean check(TreeNode subtree) {
		if (subtree.left == null && subtree.right == null) {
			count ++;
			return true;
		}
		boolean flag = true;
		if (subtree.left != null) {
			if (check(subtree.left)) {
				if (subtree.val != subtree.left.val) {
					flag = false;
				}
			} else {
				flag = false;
			}
		}
		if (subtree.right != null) {
			if (check(subtree.right)) {
				if (subtree.val != subtree.right.val) {
					flag = false;
				}
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			return false;
		}
		count ++;
		return true;
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
