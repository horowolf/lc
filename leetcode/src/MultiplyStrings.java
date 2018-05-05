


public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(adder("4356","9999"));
		//System.out.println(halfMultiply("4356",9));
		System.out.println(multiply("4352468985455786","23"));
	}
	
	public static String multiply(String num1, String num2) {
        String ans = "0";
        int digit = num2.length() - 1;
        int n = 0;
        String shift = "";
        
        if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
        
        while (digit >= 0) {
        	n = Integer.parseInt(num2.substring(digit, digit + 1));
        	ans = adder(ans, halfMultiply(num1,n) + shift);
        	digit--;
        	shift += "0";
        }
        
		return ans;
    }
	
	private static String adder(String num1, String num2) {
		String ans = "";
		int carry = 0;
		int digit1 = num1.length() - 1;
		int digit2 = num2.length() - 1;
		int n1 = 0, n2 = 0;
		
		while (digit1 >= 0 || digit2 >= 0) {
			if (digit1 >= 0) {
				n1 = Integer.parseInt(num1.substring(digit1, digit1 + 1));
			}
			if (digit2 >= 0) {
				n2 = Integer.parseInt(num2.substring(digit2, digit2 + 1));
			}
			ans = String.valueOf((n1 + n2 + carry)  % 10) + ans;
			carry = (n1 + n2 + carry) / 10;
			digit1--;
			digit2--;
			n1 = 0;
			n2 = 0;
		}
		if (carry > 0) {
			ans = String.valueOf(carry) + ans;
		}
		
		return ans;
	}
	
	private static String halfMultiply(String num1, int num2) {
		String ans = "";
		int carry = 0;
		int digit = num1.length() - 1;
		int n = 0;
		
		while (digit >= 0) {
			n = Integer.parseInt(num1.substring(digit, digit + 1));
			ans = String.valueOf(((n * num2) + carry)  % 10) + ans;
			carry = ((n * num2) + carry)  / 10;
			digit--;
			n = 0;
		}
		if (carry > 0) {
			ans = String.valueOf(carry) + ans;
		}
		
		return ans;
	}

}
