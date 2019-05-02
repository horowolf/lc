
public class BombEnemy { // 'W' 'E' '0'
	public int maxKilledEnemies(char[][] grid) {
		int max = 0;
		int x = 0;
		int y = 0;
		int kills = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					kills = 0;
					x = i;
					y = j;
					while (x >= 0) {
						if (grid[x][y] == 'W') {
							break;
						}
						if (grid[x][y] == 'E') {
							kills++;
						}
						x--;
					}
					x = i;
					while (x < grid.length) {
						if (grid[x][y] == 'W') {
							break;
						}
						if (grid[x][y] == 'E') {
							kills++;
						}
						x++;
					}
					x = i;
					y = j;
					while (y >= 0) {
						if (grid[x][y] == 'W') {
							break;
						}
						if (grid[x][y] == 'E') {
							kills++;
						}
						y--;
					}
					y = j;
					while (x < grid[0].length) {
						if (grid[x][y] == 'W') {
							break;
						}
						if (grid[x][y] == 'E') {
							kills++;
						}
						y++;
					}
					
					max = (max > kills)? max : kills;
				}
			}
		}
		
		return max;
	}
}
