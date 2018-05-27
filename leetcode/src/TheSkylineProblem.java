import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TheSkylineProblem {
	public static void main(String[] args) {
		int[][] input = {{2,4,7},{2,4,5},{2,4,6}};
		System.out.println(getSkyline(input).toString());
	}
	
	public static List<int[]> getSkyline(int[][] buildings) { // [L,R,H]
		List<int[]> skyLine = new LinkedList<int[]>();
		LinkedList<int[]> buildingTop = new LinkedList<int[]>(); // [R,H]
		int locationX = 0;
		int buildingNum = 0; // 1 ~ n
		int currentHeight = 0;
		// each iteration => move right by 1
		// if building no longer exist, remove from buildingTop
		// if have new building, add to buildingTop
		// check if Height changes, if yes, add skyline
		// iteration ends when arrive the end of buildings and no more buildings in buildingTop.
		for (; buildingNum < buildings.length || buildingTop.size() > 0; locationX++) {
			while (buildingTop.size() > 0) {
				if (buildingTop.getFirst()[0] - 1 < locationX) {
					buildingTop.removeFirst();
				} else {
					break;
				}
			}
			while (buildingNum < buildings.length && buildings[buildingNum][0] == locationX) {
				Iterator<int[]> current = buildingTop.iterator();
				int count = 0;
				while (current.hasNext()) {
					int[] buf = current.next();
					if (buf[1] > buildings[buildingNum][2]) {
						if (buf[0] >= buildings[buildingNum][1]) {
							count = -1;
							break;
						}
						count++;
					} else {
						break;
					}
				}
				if (count < 0) {
					buildingNum++;
					continue;
				}
				if (count >= buildingTop.size()) {
					int[] element = {buildings[buildingNum][1], buildings[buildingNum][2]};
					buildingTop.addLast(element);
				} else {
					int[] element = {buildings[buildingNum][1], buildings[buildingNum][2]};
					buildingTop.add(count, element);
				}
				buildingNum++;
			}
			
			if (buildingTop.isEmpty()) {
				if (currentHeight != 0) {
					currentHeight = 0;
					int[] buf = {locationX, 0};
					skyLine.add(buf);
				}
				if (buildingNum < buildings.length) {
					locationX = buildings[buildingNum][0] - 1;
				}
			} else if (buildingTop.getFirst()[1] != currentHeight) {
				currentHeight = buildingTop.getFirst()[1];
				int[] buf = {locationX, currentHeight};
				skyLine.add(buf);
			}
		}
		
		return skyLine;
    }
}
