


import java.util.Vector;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2,2,0,1,1};
		System.out.println(canJump(array));

	}
	
	public static boolean canJump(int[] nums) {
		boolean ans = false;
        int current = 0;
        int[] flag = new int[nums.length];
        flag[0] = 1;
        
        for (int i = 0; i < nums.length; i++) {
        	if (flag[i] == 0) {
        		continue;
        	}
        	if (i == nums.length - 1) {
        		ans = true;
        		break;
        	}
        	for (int j = current - i; j <= nums[i]; j++) {
        		if (i + j < nums.length) {
        			flag[i + j] = 1;
        			current = i + j;
        		}
        	}
        }
        
		return ans;
    }

}
