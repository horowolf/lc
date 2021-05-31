
public class SuperPow {
	
	public int superPow(int a, int[] b) {
		if (b.length < 1) {
			return 1;
		}
        int mod = 1;
        
        int base = a % 1337;
        for (int i = b.length - 1; i >= 0 ; i--) {
        	mod = mod * innerPow(base, b[i]) % 1337;
        	base = innerPow(base, 10);
        }
        
        return mod;
    }
	
	private int innerPow(int a, int b) {
		int r = 1;
		for (int i = 0; i < b; i++) {
			r = r * a % 1337;
		}
		return r;
	}
}
