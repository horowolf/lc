



public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2, 4));
		System.out.println(myPow(2, -4));
		System.out.println(myPow(3, 3));
		System.out.println(myPow(2.5, 2));
		System.out.println(myPow(-7, 3));
		System.out.println(myPow(2, -2147483648));
	}
	public static double myPow(double x, int n) {
		double ans = 1;
		double hold = 1;
		int isP = 1;
		int edge = 0;
		if (n == -2147483648) {
			n += 1;
			edge = 1;
		}
		if (n < 0) {
			isP = -1;
			n *= -1;
		}
		hold = x;
		while(n > 0) {
			if (n % 2 == 1) {
				ans *= hold;
			}
			n /= 2;
			hold *= hold;
		}
		if (isP == -1) {
			ans = 1 / ans;
		}
		if (edge == 1) {
			ans /= x;
		}
		/*
		if (n > 0) {
			for (; n > 0; n--) {
				ans *= x;
			}
		} else {
			for (; n < 0; n++) {
				ans /= x;
			}
		}
		*/
        return ans;
    }
}
