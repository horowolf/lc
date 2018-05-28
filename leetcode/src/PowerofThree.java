
public class PowerofThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfThree(Integer.MAX_VALUE));
	}
	
	public static boolean isPowerOfThree(int n) { // Q 326
        if (n < 1) {
        	return false;
        }
        while (n % 3 == 0) {
        	n = n / 3;
        }
        
        if (n == 1) {
        	return true;
        }
        return false;
        
    }

}
