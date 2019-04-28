
public class AddStrings {
	public String addStrings(String num1, String num2) {
		String result = "";
		int carry = 0;
		int i = 1;
		for (; i <= num1.length() || i <= num2.length(); i++) {
			int n1 = 0;
			if (i <= num1.length()) {
				n1 = Integer.parseInt(num1.substring(num1.length() - i, num1.length() - i + 1));
			}
			int n2 = 0;
			if (i <= num2.length()) {
				n2 = Integer.parseInt(num2.substring(num2.length() - i, num2.length() - i + 1));
			}
			result = String.valueOf((n1 + n2 + carry) % 10) + result;
			carry = (n1 + n2 + carry) / 10;
			
		}
		if (carry != 0) {
			result = String.valueOf(carry) + result;
		}
		
        return result;
    }
}
