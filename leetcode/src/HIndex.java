import java.util.ArrayList;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {4,3,2,6,7,5};
		System.out.println(hIndex(input));
	}
	
	public static int hIndex(int[] citations) { //Q 274
        ArrayList<Integer> list = new ArrayList<Integer>(citations.length);
        
        for (int i = 0; i < citations.length; i++) {
        	list.add(citations[i]);
        }
		
        list.sort(null);
        
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
        	int min = (citations.length - i < list.get(i))? citations.length - i : list.get(i);
        	max = (max > min)? max : min;
        }
        
		return max;
    }

}
