import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
	
	public static void main(String[] args) {
		System.out.println(readBinaryWatch(1));
	}
	
	public static List<String> readBinaryWatch(int num) {
		List<String> result = new LinkedList<String>();
		HashMap<Integer, HashSet<Integer>> hrList = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> minList = new HashMap<Integer, HashSet<Integer>>();
		
		for (int i = 0; i < 12; i++) {
			HashSet<Integer> buf = hrList.get(Integer.bitCount(i));
			if (buf == null) {
				buf = new HashSet<Integer>();
			}
			buf.add(i);
			hrList.put(Integer.bitCount(i), buf);
		}
		
		for (int i = 0; i < 60; i++) {
			HashSet<Integer> buf = minList.get(Integer.bitCount(i));
			if (buf == null) {
				buf = new HashSet<Integer>();
			}
			buf.add(i);
			minList.put(Integer.bitCount(i), buf);
		}
		
		for (int i = num; i >= 0; i--) {
			if (i > 3) {
				i = 3;
			}
			if (num - i > 5) {
				continue;
			}
			for (int hr : hrList.get(i)) {
				for (int min : minList.get(num - i)) {
					result.add(getTime(hr, min));
				}
			}
		}
		
        return result;
	}
	
	private static String getTime(int hr, int min) {
		return intToString(hr) + ":" + intTominute(min);
	}
	
	private static String intTominute(int num) {
		if (num < 10) {
			return "0" + intToString(num);
		}
		return intToString(num);
	}
	
	private static String intToString(int num) {
		return String.valueOf(num);
	}

}
