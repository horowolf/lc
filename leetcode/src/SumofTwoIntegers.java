
public class SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(3, -10));
	}
	
	public static int getSum(int a, int b) {
		int c; 
		while(b !=0 ) {
			c = (a&b);
			a = a ^ b;
			b = (c)<<1;
			}
		return a;
	        
	}

}
