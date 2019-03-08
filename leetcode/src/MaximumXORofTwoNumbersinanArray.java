import java.util.HashSet;
import java.util.Iterator;

public class MaximumXORofTwoNumbersinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = new int[]{10, 2, 8};
		System.out.println(findMaximumXOR(n));
		
	}
	
	public static int findMaximumXOR(int[] nums) {
		int highestBit = 0;
		HashSet<Integer> set = new HashSet<Integer>();
        
        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (highestBit < Integer.highestOneBit(nums[i])) {
        		highestBit = Integer.highestOneBit(nums[i]);
			}
        }
        
		for (int i = 0; i < nums.length; i++) {
			if (highestBit <= nums[i]) {
				set.add(nums[i]);
			}
		}
		
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			int maxNum = iter.next();
			for (int i = 0; i < nums.length; i++) {
				int x = nums[i] ^ maxNum;
				if (maxResult < x) {
					maxResult = x;
				}
			}
		}
		
        
        return maxResult;
    }
}
