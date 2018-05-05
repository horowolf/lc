


public class countAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(6));
	}
	
	public static String countAndSay(int n) {
		String ans = "1";
		String pre;
		String post;
		int count;
		while (n > 1) {
			String buf = "";
			while (ans.length() > 0) {
				count = 1;
				post = ans.substring(0, 1);
				while (true) {
					if (count + 1 >  ans.length() || !post.equals(ans.substring(count, count + 1)) ) {
						break;
					}
					count++;
				}
				pre = Integer.toString(count);
				buf = buf + pre + post;
				ans = ans.substring(count);
			}
			
			ans = buf;
			n--;
		}
		
		return ans;
    }

}
