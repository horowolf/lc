
public class maxAreaOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
		
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			int size = landRemove(grid, i, j);
        			if (size > max) max = size;
        		}
        	}
        }
        
		return max;
    }
	
	private int landRemove(int[][] grid, int x, int y) {
		int landSize = 1;
		grid[x][y] = 0;
		if (x > 0) {
			if (grid[x - 1][y] == 1) {
				landSize += landRemove(grid, x - 1, y);
			}
		}
		if (y > 0) {
			if (grid[x][y - 1] == 1) {
				landSize += landRemove(grid, x, y - 1);
			}
		}
		if (x < grid.length - 1) {
			if (grid[x + 1][y] == 1) {
				landSize += landRemove(grid, x + 1, y);
			}
		}
		if (y < grid[0].length - 1) {
			if (grid[x][y + 1] == 1) {
				landSize += landRemove(grid, x, y + 1);
			}
		}
		
		return landSize;
	}
}
