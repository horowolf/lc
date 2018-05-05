

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("dvf"));

	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		int ans = 0;
		String sub = "";
		int start = -1;
		int end = 0;
		sub = s.substring(0, 1);
		for (; end < s.length();) {
			
			start = start + sub.indexOf(s.charAt(end)) + 1;
			
			sub = s.substring(start, end + 1);
			if (end - start + 1 > ans) {
				ans = end - start + 1;
			}
			end++;
		}
		
		return ans;
		/*  //  Takes too long
		int ans = 0;
		int buf = 0;
		HashMap h = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			if (h.get(s.charAt(i)) == null) {
				h.put(s.charAt(i), i);
				buf++;
			} else {
				i = (int)h.get(s.charAt(i));
				h.clear();
				if (buf > ans) {
					ans = buf;
				}
				buf = 0;
			}
		}
		h.clear();
		if (buf > ans) {
			ans = buf;
		}
		return ans;
		*/
    }
}
