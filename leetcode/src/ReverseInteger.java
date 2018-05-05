


public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483642));
	}
	
	public static int reverse(int x) {
        long preAns = 0;
        int signed = 1;
        if (x < 0) {
        	signed = -1;
        	x = x * signed;
        }
        
        while (x > 0) {
        	preAns = preAns * 10 + x % 10;
        	x = x / 10;
        }
        
        preAns = preAns * signed;
        
        if (preAns > Integer.MAX_VALUE || preAns < Integer.MIN_VALUE) {
        	return 0;
        }
        int ans = (int)preAns;
		return ans;
    }

}
