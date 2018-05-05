


public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("00", "021"));

	}
	public static String addBinary(String a, String b) {
        String ans = "";
        int carry = 0;
        int location = 1;
        int abit = 0;
        int bbit = 0;
        int cbit = 0;
        
        if (a.length() == 0 && b.length() == 0) {
        	return "0";
        }
        if (a.length() == 0) {
        	return b;
        } else if (b.length() == 0) {
        	return a;
        }
        
        int dif = a.length() - b.length();
        if (dif > 0) {
        	String buf = "";
        	for (int i = 0; i < dif; i++) {
        		buf = "0" + buf;
        	}
        	b = buf + b;
        } else if (dif < 0) {
        	String buf = "";
        	for (int i = 0; i > dif; i--) {
        		buf = "0" + buf;
        	}
        	a = buf + a;
        }
        
        for (; location <= a.length(); location++) {
        	abit = a.charAt(a.length() - location) & '\017';
        	bbit = b.charAt(b.length() - location) & '\017';
        	cbit = abit + bbit + carry;
        	carry = cbit / 2;
        	cbit = cbit % 2;
        	ans = String.valueOf(cbit) + ans;
        }
        
        if (carry == 1) {
        	ans = "1" + ans;
        }
        
        int start = ans.indexOf("1");
        if (start >= 0) {
        	ans = ans.substring(start);
        }
        
		return ans;
    }

}
