
public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int sl1 = s1.length(), sl2 = s2.length();
        
        if (s3.length() != sl1 + sl2) return false;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        if (s2.length() == 0) return s3.equals(s1);
        if (s1.length() == 0) return s3.equals(s2);
        
        // dp store
        boolean[][] dp = new boolean[sl1 + 1][sl2 + 1];
        
        
        /* Base conditions for the DP */
        int idx = sl1 - 1;
        int counter = 0;
        while(idx >= 0) {
            if (s1.charAt(idx) == s3.charAt(s3.length() - 1 - counter)) {
                dp[idx][sl2] = true;
                counter++;
                idx--;
            } else {
                break;
            }
        }
        
        counter = 0;
        idx = sl2- 1;
        while(idx >= 0) {
            if (s2.charAt(idx) == s3.charAt(s3.length() - 1 - counter)) {
                dp[sl1][idx] = true;
                counter++;
                idx--;
            } else {
                break;
            }
        }
        
        /* Fill the DP matrix */
        for (int i = sl1 - 1; i >= 0; i--) {
            for (int j = sl2 - 1; j >= 0; j--) {
                dp[i][j] = (s3.charAt(i + j) == s1.charAt(i) && dp[i + 1][j]) || (s3.charAt(i + j) == s2.charAt(j) && dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }
	
	
	// Too slow
	boolean hasSame(String s1, String s2, String s3, int i1, int i2, int i3) {
		if (i1 == s1.length() && i2 == s2.length()) {
			return true;
		}
		
		if (i1 < s1.length()) {
			if (s1.charAt(i1) == s3.charAt(i3)) {
				if (hasSame(s1, s2, s3, i1 + 1, i2, i3 + 1)) {
					return true;
				}
			}
		}
		
		if (i2 < s2.length()) {
			if (s2.charAt(i2) == s3.charAt(i3)) {
				if (hasSame(s1, s2, s3, i1, i2 + 1, i3 + 1)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
