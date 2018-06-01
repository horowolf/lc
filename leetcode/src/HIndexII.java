public class HIndexII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,1,3,5,6};
		System.out.println(hIndex(input));
	}
	
	public static int hIndex(int[] citations) { //Q 275
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
        	int min = (citations.length - i < citations[i])? citations.length - i : citations[i];
        	max = (max > min)? max : min;
        }
        
		return max;
    }
}
