
public class AddDigits {
	public static void main(String[] args) {
		System.out.println(addDigits(4256));
	}
	public static int addDigits(int num) {
		if (num == 0) {
            return num;
        }
        int n = num % 9;
        if (n == 0) {
            return 9;
        }
        return n;
    }
}
