
public class DiffOfInt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(XORcount(1, 5));
	}
	
	public static int XORcount(int x, int y) {
		int count = 0;
		int z = x ^ y;
		
		while (z != 0) {
			count += z % 2;
			z = z / 2;
		}
		
		return count;
	}
	
}
