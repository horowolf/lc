import java.util.LinkedList;

public class FindMedianfromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MedianFinder { // Q 295

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
    }
    
    public double findMedian() {
    	
    	return 0;
    	
    }
    
    class Node {
    	
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