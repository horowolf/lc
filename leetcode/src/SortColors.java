
public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sortColors(int[] nums) {
		if (nums.length < 1) {
			return;
		}
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	switch (nums[i]) {
        	case 0:
        		red++;
        		break;
        	case 1:
        		white++;
        		break;
        	case 2:
        		blue++;
        		break;
        	default:
        		System.out.println(nums[i]);
        	}
        }
        
        for (int i = 0; i < nums.length; i++) {
        	for (; red > 0; i++, red--) {
        		nums[i] = 0;
        	}
        	for (; white > 0; i++, white--) {
        		nums[i] = 1;
        	}
        	for (; blue > 0; i++, blue--) {
        		nums[i] = 2;
        	}
        }
    }

}
