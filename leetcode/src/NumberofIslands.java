
public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numIslands(char[][] grid) {
        int result = 0;
		
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == '1') {
        			result ++;
        			landRemove(grid, i, j);
        		}
        	}
        }
        
		return result;
    }
	
	private void landRemove(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		if (x > 0) {
			if (grid[x - 1][y] == '1') {
				landRemove(grid, x - 1, y);
			}
		}
		if (y > 0) {
			if (grid[x][y - 1] == '1') {
				landRemove(grid, x, y - 1);
			}
		}
		if (x < grid.length - 1) {
			if (grid[x + 1][y] == '1') {
				landRemove(grid, x + 1, y);
			}
		}
		if (y < grid[0].length - 1) {
			if (grid[x][y + 1] == '1') {
				landRemove(grid, x, y + 1);
			}
		}
	}
}
