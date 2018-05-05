


public class atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("efgq11228552307"));
	}
	public static int myAtoi(String str) {
        int ans = 0;
        boolean counting = false;
        int signed = 1;
        int warning = Integer.MAX_VALUE / 10;
        int danger = 0;
        
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        		counting = true;
        		if (ans >= warning) {
        			if (signed == 1 && (str.charAt(i) > '7' || danger == 1)) {
        				return Integer.MAX_VALUE;
        			}
        			if (signed == -1 && (str.charAt(i) > '8' || danger == 1)) {
        				return Integer.MIN_VALUE;
        			}
        			if (ans >= 1000000000) {
        				if (signed == 1) {
        					return Integer.MAX_VALUE;
        				} else {
        					return Integer.MIN_VALUE;
        				}
        			}
        			danger = 1;
        		}
        		ans = ans * 10 + (str.charAt(i) & '\017');
        	} else {
        		if (counting == true) {
        			break;
        		}
        		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
        			counting = true;
        			if (i + 1 >= str.length()) {
        				break;
        			}
        			if (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
        				if (str.charAt(i) >= '-') {
        					signed = -1;
        				}
        			}
        		} else if (str.charAt(i) != ' ') {
        			break;
        		}
        	}
        }
        ans *= signed;
        
        return ans;
    }

}
