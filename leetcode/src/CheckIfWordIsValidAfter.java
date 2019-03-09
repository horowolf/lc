
public class CheckIfWordIsValidAfter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("ababccabcaababccbc"));
	}
	
	public static boolean isValid(String S) {
        // S = "abc" <= valid string
		while (S.contains("abc")) {
			S = S.replace("abc", "");
			if (S.equals("")) {
				return true;
			}
		}
		return false;
    }

}
