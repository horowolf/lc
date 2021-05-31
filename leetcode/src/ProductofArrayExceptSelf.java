
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productExceptSelf(new int[]{1,2,3,4});
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int[] fromLeft = new int[nums.length];
		int[] fromRight = new int[nums.length];
		int[] result = new int[nums.length];
		
		fromLeft[0] = 1;
		fromRight[nums.length - 1] = 1;
		
		for (int i = 1; i < nums.length; i++) {
			fromLeft[i] = fromLeft[i - 1] * nums[i - 1];
		}
		
		for (int i = nums.length - 2; i >= 0; i--) {
			fromRight[i] = fromRight[i + 1] * nums[i + 1];
		}
		
		for (int i = 0; i < nums.length; i++) {
			result[i] = fromLeft[i] * fromRight[i];
		}
		
		return result;
    }

}
