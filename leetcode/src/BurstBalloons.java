import java.util.HashMap;
import java.util.LinkedList;

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int maxCoins(int[] nums) { // Q 312
        LinkedList<Node> list = new LinkedList<Node>();
        LinkedList<Integer> balloon = new LinkedList<Integer>(); // or node?
		
        for (int i = 0; i < nums.length; i++) {
        	Integer v = new Integer(nums[i]);
        	Node buf = new Node(nums[i], v);
        	
        	balloon.add(v);
        	list.add(buf);
        }
        
        list.sort((n1, n2) -> n1.val - n2.val); // check?
        
        Integer v = list.poll().point;
        
        int location = balloon.indexOf(v);
        
        
		
		return 0;
    }
	
	static class Node {
		int val;
		Integer point; // or node?
		protected Node(int value, Integer p) {
			val = value;
			point = p;
		}
	}

}
