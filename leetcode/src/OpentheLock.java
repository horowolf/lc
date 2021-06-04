import java.util.LinkedList;

public class OpentheLock {
	
	public static void main(String[] args) {
		
		String[] s = {"0201","0101","0102","1212","2002"};
		
		System.out.println(openLock(s, "0202"));
	}
	public static int openLock(String[] deadends, String target) {
		int[][][][] map = new int[10][10][10][10];
		map[target.charAt(0) & '\017'][target.charAt(1) & '\017'][target.charAt(2) & '\017'][target.charAt(3) & '\017'] = 2;
		
		for (int i = 0; i < deadends.length; i++) {
			map[deadends[i].charAt(0)& '\017'][deadends[i].charAt(1)& '\017'][deadends[i].charAt(2)& '\017'][deadends[i].charAt(3)& '\017'] = 1;
		}
		if (map[0][0][0][0] == 1) {
			return -1;
		}
		if (map[0][0][0][0] == 2) {
			return 0;
		}
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(new Node(0, 0, 0, 0, 0));
		
		while (list.size() > 0) {
			Node temp = list.pollFirst();
			if (map[addOne(temp.a)][temp.b][temp.c][temp.d] != 1) {
				if (map[addOne(temp.a)][temp.b][temp.c][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[addOne(temp.a)][temp.b][temp.c][temp.d] = 1;
				list.add(new Node(addOne(temp.a), temp.b, temp.c, temp.d, temp.turns + 1));
			}
			if (map[minusOne(temp.a)][temp.b][temp.c][temp.d] != 1) {
				if (map[minusOne(temp.a)][temp.b][temp.c][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[minusOne(temp.a)][temp.b][temp.c][temp.d] = 1;
				list.add(new Node(minusOne(temp.a), temp.b, temp.c, temp.d, temp.turns + 1));
			}
			if (map[temp.a][addOne(temp.b)][temp.c][temp.d] != 1) {
				if (map[temp.a][addOne(temp.b)][temp.c][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][addOne(temp.b)][temp.c][temp.d] = 1;
				list.add(new Node(temp.a, addOne(temp.b), temp.c, temp.d, temp.turns + 1));
			}
			if (map[temp.a][minusOne(temp.b)][temp.c][temp.d] != 1) {
				if (map[temp.a][minusOne(temp.b)][temp.c][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][minusOne(temp.b)][temp.c][temp.d] = 1;
				list.add(new Node(temp.a, minusOne(temp.b), temp.c, temp.d, temp.turns + 1));
			}
			if (map[temp.a][temp.b][addOne(temp.c)][temp.d] != 1) {
				if (map[temp.a][temp.b][addOne(temp.c)][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][temp.b][addOne(temp.c)][temp.d] = 1;
				list.add(new Node(temp.a, temp.b, addOne(temp.c), temp.d, temp.turns + 1));
			}
			if (map[temp.a][temp.b][minusOne(temp.c)][temp.d] != 1) {
				if (map[temp.a][temp.b][minusOne(temp.c)][temp.d] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][temp.b][minusOne(temp.c)][temp.d] = 1;
				list.add(new Node(temp.a, temp.b, minusOne(temp.c), temp.d, temp.turns + 1));
			}
			if (map[temp.a][temp.b][temp.c][addOne(temp.d)] != 1) {
				if (map[temp.a][temp.b][temp.c][addOne(temp.d)] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][temp.b][temp.c][addOne(temp.d)] = 1;
				list.add(new Node(temp.a, temp.b, temp.c, addOne(temp.d), temp.turns + 1));
			}
			if (map[temp.a][temp.b][temp.c][minusOne(temp.d)] != 1) {
				if (map[temp.a][temp.b][temp.c][minusOne(temp.d)] == 2) {
					return temp.turns + 1;
				}
				map[temp.a][temp.b][temp.c][minusOne(temp.d)] = 1;
				list.add(new Node(temp.a, temp.b, temp.c, minusOne(temp.d), temp.turns + 1));
			}
		}
		
        return -1;
    }
	
	private static int addOne(int num) {
		if (num + 1 > 9) {
			return 0;
		}
		return num + 1;
	}
	
	private static int minusOne(int num) {
		if (num - 1 < 0) {
			return 9;
		}
		return num - 1;
	}
	
	static class Node {
		int a;
		int b;
		int c;
		int d;
		int turns;
		public Node (int a, int b, int c, int d, int turns) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.turns = turns;
		}
	}
}
