import java.util.LinkedList;

public class FindMedianfromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder m = new MedianFinder();
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(10);
		System.out.println(m.findMedian());
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(5);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
	}

}

class MedianFinder { // Q 295
	Node root = null;

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
    	if (root == null) {
    		root = new Node(num);
    	} else {
    		adder(root, num);
    	}
    }
    
    public void adder(Node n, int num) {
    	if (n.val == num) {
    		n.numThis++;
    		return;
    	}
    	if (num < n.val) {
    		n.numL++;
    		if (n.left != null) {
    			adder(n.left, num);
    		} else {
    			n.left = new Node(num);
    		}
    	} else {
    		n.numR++;
    		if (n.right != null) {
    			adder(n.right, num);
    		} else {
    			n.right = new Node(num);
    		}
    	}
    }
    
    public double findMedian() {
    	int total = root.numL + root.numThis + root.numR;
    	int extra = (total + 1) % 2;
    	int mid = (total + 1) / 2; // mid of 0 ~ n-1
    	System.out.println(mid);
    	return finder(root, mid, extra);
    }
    
    public double finder(Node n, int kth, int extra) {
    	if (extra == 0) {
    		if (n.numL >= kth) {
    			return finder(n.left, kth, 0);
    		} else if (n.numL + n.numThis >= kth) {
    			return n.val;
    		} else {
    			return finder(n.right, kth - (n.numL + n.numThis), 0);
    		}
    	} else {
    		if (n.numL >= kth + 1) { // both left
    			return finder(n.left, kth, 1);
    		} else if (!(n.numL == kth) && n.numL + n.numThis >= kth + 1 && n.numThis > 1) { // both this
    			return n.val;
    		} else if (n.numL + n.numThis < kth){ // both right
    			return finder(n.right, kth - (n.numL + n.numThis), 1);
    		} else {
    			double a = 0;
    			double b = 0;
    			if (n.numL >= kth) {
        			a = finder(n.left, kth, 0);
        		} else if (n.numL + n.numThis >= kth) {
        			a = n.val;
        		} else {
        			a = finder(n.right, kth - (n.numL + n.numThis), 0);
        		}
    			if (n.numL >= kth + 1) {
        			b = finder(n.left, kth + 1, 0);
        		} else if (n.numL + n.numThis >= kth + 1) {
        			b = n.val;
        		} else {
        			b = finder(n.right, kth + 1 - (n.numL + n.numThis), 0);
        		}
    			return (a + b) / 2.0;
    		}
    	}
    	
    }
    
    class Node {
    	int val;
    	int numThis = 1;
    	Node left = null;
    	int numL = 0;
    	Node right = null;
    	int numR = 0;
    	
    	protected Node (int value) {
    		val = value;
    	}
    	
    }
}


/*  Fast coding, bad time complexity
class MedianFinder { // Q 295
	LinkedList<Integer> list;

    // initialize your data structure here.
    public MedianFinder() {
        list = new LinkedList<Integer>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
    	if (list.size() < 1) {
    		return 0;
    	}
        list.sort(null);
    	
        if (list.size() % 2 == 1) {
        	return list.get(list.size() / 2);
        } else {
        	double a = list.get(list.size() / 2);
        	double b = list.get((list.size() / 2) - 1);
        	return (a + b) / 2.0;
        }
        
    }
}
*/