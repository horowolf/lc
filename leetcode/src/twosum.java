


import java.util.HashMap;

public class twosum {

	public static void main(String[] args) {
		int[] a = {3,2,4};
		System.out.print(twosum(a, 6));

	}

	public static int[] twosum(int[] nums, int target) {
    	int[] ans = new int[2];
    	HashMap h = new HashMap();
    	for (int i = 0; i < nums.length; i++) {
    		h.put(nums[i], i);
    	}
    	for (int i = 0; i < nums.length; i++) {
    		int t = target - nums[i];
    		System.out.println(h.get(target - nums[i]));
    		if (h.get(t) != null){
    			int a = (int)h.get(t);
    			if(a != i) {
    				ans[0] = i;
        			ans[1] = a;
        			break;
    			}
    		}
    	}
    	System.out.println(ans[0] + " " + ans[1]);
		return ans;
    }
}
