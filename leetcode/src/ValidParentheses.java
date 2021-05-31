import java.util.Stack;


public class ValidParentheses {
	
	public static void main(String[] args) {
		String s = "{[()()]}";
		System.out.print(isValid(s));

	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ')' && c != ']' && c != '}') {
				stack.push(c);
				continue;
			}
			if (stack.empty()) return false;
			char popout = stack.pop();
			if (popout == '(') {
				if (c != ')') return false;
			} else if (popout == '[') {
				if (c != ']') return false;
			} else { // '{'
				if (c != '}') return false;
			}
		}
		if (!stack.empty()) return false;
		return true;
    }
}
