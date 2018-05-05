


import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = {9, 9};
		System.out.println(Arrays.toString(plusOne(m)));
	}
	
	public static int[] plusOne(int[] digits) {
        int[] ans = Arrays.copyOf(digits, digits.length);
        int carry = 1;
        
        for (int d = digits.length - 1; d >= 0; d--) {
        	int k = (carry + ans[d]) % 10;
        	carry = (carry + ans[d]) / 10;
        	ans[d] = k;
        	
        	if (carry == 0) break;
        }
        
        if (carry == 1) {
        	int[] a = new int[ans.length + 1];
        	System.arraycopy(ans, 0, a, 1, ans.length);
        	a[0] = 1;
        	return a;
        }
        
		return ans;
    }

}
