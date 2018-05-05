


public class sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(2147395600));
	}
	
	public static int mySqrt(int x) { // There's a better way to run it faster.
        int ans = 0;
        while (true) {
        	if ((long)(ans + 1) * (ans + 1) <= x) {
        		ans++;
        	} else {
        		break;
        	}
        }
        return ans;
    }

}
