
public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(String.valueOf(calculateMinimumHP(map)));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) { // Q174
		// if dungeon is empty or only 1 row/col?
		
        // for-for
		// check x/y at edge
		int w = dungeon[0].length - 1;
		int h = dungeon.length - 1;
		int a = 0;
		int b = 0;
		int y = h;
		int x = w - 1; // skip bottom-right
		if (dungeon[h][w] > 0) {
			dungeon[h][w] = 0;
		}
		for (; y >= 0; y--) {
			for (; x >=0; x--) {
				if (y == dungeon.length - 1) {
					dungeon[y][x] = dungeon[y][x] + dungeon[y][x + 1];
				} else if (x == dungeon[0].length - 1) {
					dungeon[y][x] = dungeon[y][x] + dungeon[y + 1][x];
				} else {
					dungeon[y][x] = (dungeon[y][x] + dungeon[y][x + 1] > dungeon[y][x] + dungeon[y + 1][x])? dungeon[y][x] + dungeon[y][x + 1]: dungeon[y][x] + dungeon[y + 1][x];
				}
				
				if (dungeon[y][x] > 0) {
					dungeon[y][x] = 0;
				}
			}
			x = w;
		}
		
		return 1 - dungeon[0][0];
    }

}
