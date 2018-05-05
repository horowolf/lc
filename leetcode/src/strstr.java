


public class strstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("babacabc","abc"));
	}
	
	public static int strStr(String haystack, String needle) {
		// return haystack.indexOf(needle);  <= damn
        int ans = -1;
		int keep = 0;
		
		if (needle.length() == 0) {
			return 0;
		}
		
		for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				keep = isStr(haystack.substring(i, i + needle.length()), needle);
			}
			if (keep == -1) {
				return i;
			}
			i = i + keep;
		}
		
        return ans;
    }
	
	private static int isStr(String s, String n) {
		
		int keep = 0;
		
		for (int i = 1; i < n.length(); i++) {
			if (keep > 0 && s.charAt(i) == n.charAt(0)) {
				keep = i;
			}
			if (s.charAt(i) != n.charAt(i)) {
				return keep;
			}
		}
		
		return -1;
	}

}
