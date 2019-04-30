
public class ValidPerfectSquare {
	public static void main () {
		System.out.print(isPerfectSquare(2147483647));
	}
	
	public static boolean isPerfectSquare(int num) { // O(sqrt(n)) from discussion
		int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
    }
}
/*  // Time Limit Exceeded O(log n)
	public static boolean isPerfectSquare(int num) {
		int i = 1;
		if (num < 1) {
			return false;
		}
		int left = 1;
		int right = num;
		do {
			int mid = (left + right) / 2;
			if (mid * mid > num) {
				right = mid - 1;
			} else if (mid * mid == num) {
				return true;
			} else { // mid * mid < num => only num around 2
				left = mid + 1;
			}
		} while (left != right);
		return false;
	}
*/