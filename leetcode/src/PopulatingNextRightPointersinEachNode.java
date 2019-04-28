import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node r = new Node();
		r.val = 1;
		Node rl = new Node();
		rl.val = 2;
		Node rr = new Node();
		rr.val = 3;
		r.left = rl;
		r.right = rr;
		connect(r);
	}
	
	public static Node connect(Node root) {
        if (root == null) {
        	return null;
        }
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        linker(list);
        return root;
    }
	
	private static void linker(LinkedList<Node> list) {
		LinkedList<Node> nextList = new LinkedList<Node>();
		Node n = list.pollFirst();
		while (n != null) {
			if (n.left != null) {
				nextList.add(n.left);
			}
			if (n.right != null) {
				nextList.add(n.right);
			}
			Node next = list.pollFirst();
			n.next = next;
			n = next;
		}
		if (nextList.isEmpty()) {
			return;
		}
		linker(nextList);
	}
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};