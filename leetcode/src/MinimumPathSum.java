


public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,3,1},
		                 {1,5,1},
		                 {4,2,1}};
		System.out.println(String.valueOf(minPathSum(input)));
	}
	public static int minPathSum(int[][] grid) {
        int ans = -1;
        // check if grid is empty
        if (grid.length == 0) {
        	return 0;
        }
        //start from top-left, skip (0,0)
        int x = 1;
        int y = 0;
        int a = 0; // left
        int b = 0; // up
        for (; y < grid.length; y++) { // go through every elements
        	for (; x < grid[y].length; x++) {
        		if (x == 0) {
        			a = Integer.MAX_VALUE;
        			b = grid[y - 1][x];
        		} else if (y == 0) {
        			a = grid[y][x - 1];
        			b = Integer.MAX_VALUE;
        		} else {
        			a = grid[y][x - 1];
        			b = grid[y - 1][x];
        		}
        		// x = 0, y = 0 should never happen
        		grid[y][x] = grid[y][x] + min(a, b);
        	}
        	x = 0;
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
	
	private static int min(int a, int b) {
		return (a < b)? a: b;
	}
}
