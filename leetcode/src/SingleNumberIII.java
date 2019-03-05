import java.util.HashSet;
import java.util.Iterator;

public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] singleNumber(int[] nums) {
        HashSet h1 = new HashSet();
        HashSet h2 = new HashSet();
        
        for (int i = 0; i < nums.length; i++) {
        	if (h1.contains(nums[i])) {
        		h2.add(nums[i]);
        	} else {
        		h1.add(nums[i]);
        	}
        }
        
        Iterator iter = h2.iterator();
        while (iter.hasNext()) {
        	h1.remove(iter.next());
        }
		
        iter = h1.iterator();
		int[] r = new int[2];
		int c = 0;
		while (iter.hasNext()) {
			if (c > 2) break;
			r[c] = (int) iter.next();
			c++;
		}
		
		return r;
    }

}
