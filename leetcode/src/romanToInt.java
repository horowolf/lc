


public class romanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("CDIV"));
	}
	//Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）
	public static int romanToInt(String s) {
        int ans = 0;
		String str = s;
		while (str.length() > 0) {
			switch (str.charAt(0)) {
			case 'M':
				ans += 1000;
				str = str.substring(1);
				break;
			case 'D':
				ans += 500;
				str = str.substring(1);
				break;
			case 'C':
				if (str.length() > 1 && str.charAt(1) == 'M') {
					ans += 900;
					str = str.substring(2);
				} else if (str.length() > 1 && str.charAt(1) == 'D') {
					ans += 400;
					str = str.substring(2);
				} else {
					ans += 100;
					str = str.substring(1);
				}
				break;
			case 'L':
				ans += 50;
				str = str.substring(1);
				break;
			case 'X':
				if (str.length() > 1 && str.charAt(1) == 'C') {
					ans += 90;
					str = str.substring(2);
				} else if (str.length() > 1 && str.charAt(1) == 'L') {
					ans += 40;
					str = str.substring(2);
				} else {
					ans += 10;
					str = str.substring(1);
				}
				break;
			case 'V':
				ans += 5;
				str = str.substring(1);
				break;
			case 'I':
				if (str.length() > 1 && str.charAt(1) == 'X') {
					ans += 9;
					str = str.substring(2);
				} else if (str.length() > 1 && str.charAt(1) == 'V') {
					ans += 4;
					str = str.substring(2);
				} else {
					ans += 1;
					str = str.substring(1);
				}
				break;
				
			}
			
			
		}
		
		
		return ans;
    }

}
