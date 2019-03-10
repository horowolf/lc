import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3},{7,5},{8,6},{9,7}}));
	}
	
	public static int maxEnvelopes(int[][] envelopes) {

        HashMap<Integer, HashSet<Integer>> list = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < envelopes.length; i++) {
			HashSet<Integer> n = list.get(envelopes[i][0]);
			if (n != null) {
				n.add(envelopes[i][1]);
			} else {
				n = new HashSet<Integer>();
				n.add(envelopes[i][1]);
			}
			list.put(envelopes[i][0], n);
		}
		
		int count = 0;
		int w = 0;
		int h = 0;
		while (list.size() > 0) {
			w = Collections.min(list.keySet());
			HashSet<Integer> s = list.get(w);
			while (s.size() > 0) {
				if (h < Collections.min(s)) {
					h = Collections.min(s);
					count++;
					break;
				}
				s.remove(Collections.min(s));
			}
			
			list.remove(w);
		}
		
		return count;
    }
		
}