
public class PowerofFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(4));
	}
	public static boolean isPowerOfFour(int num) {
        return num > 0 && (Integer.bitCount(num) == 1) && (num & 0xaaaaaaaa) == 0;
    }

}
