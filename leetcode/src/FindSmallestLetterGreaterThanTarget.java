
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        int mid = 0;
        
        while (left < right) {
        	mid = (left + right) / 2;
        	if (letters[mid] > target) {
        		right = mid;
        	} else {
        		left = mid + 1;
        	}
        }
        
        if (left >= letters.length) {
        	return letters[0];
        }
		return letters[left];
    }
}
