
public class PowerofFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(5));
	}
	public static boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && (num & 0xaaaaaaaa) == 0;
    }

}
