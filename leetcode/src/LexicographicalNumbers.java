import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lexicalOrder(13);
	}
	
	public static List<Integer> lexicalOrder(int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Node root = new Node(); // empty but have children
		Node ptr = root;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int buf = 0;
		int hold = 0;
		
		for (int i = 1; i <= n; i++) {
			buf = i;
			while (buf > 0) {
				stack.add(buf % 10);
				buf = buf / 10;
			}
			ptr = root;
			while (stack.size() > 0) {
				hold = stack.pollLast();
				if (ptr.node[hold] != null) {
					ptr = ptr.node[hold];
				} else {
					ptr.node[hold] = new Node();
					ptr = ptr.node[hold];
				}
			}
			ptr.available = i;
			ptr = root;
		}
		
		traversal(list, root);
		
		return list;
    }
	
	private static void traversal(LinkedList<Integer> list, Node node) {
		if (node == null) {
			return;
		}
		if (node.available > 0) {
			list.add(node.available);
		}
		for (int i = 0; i < 10; i++) {
			traversal(list, node.node[i]);
		}
	}
	
	static class Node {
		int available = 0;
		Node[] node = new Node[10];
	}
	
	public List<Integer> lexicalOrderBetter(int n) {
        List<Integer> list = new ArrayList();

		for(int i=1;i<=9;i++){
		   helper(n,i,list); 
		}

		return list;
    }
	
	public void helper(int n,int i,List<Integer> list){
		if(i>n)
			return;
		list.add(i);

		for(int k=0;k<10;k++){
			helper(n,i*10+k,list);
		}
	}
}
