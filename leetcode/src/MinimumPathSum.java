


public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,3,1}};
		System.out.println(String.valueOf(minPathSum(input)));
	}
	public static int minPathSum(int[][] grid) {
        int ans = -1;
		
		if (grid.length < 1 && grid[0].length < 1) {
			return grid[0][0];
		}
		
		if (!(grid.length < 1)) {
			for (int i = 1; i < grid[0].length ; i++) {
            	grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
			
		}
		
        if (!(grid[0].length < 1)) {
        	for (int i = 1; i < grid.length ; i++) {
	        	grid[0][i] = grid[0][i - 1] + grid[0][i];
	        }
        }
        
        
        if (grid.length < 1 || grid[0].length < 1) {
			return grid[grid[0].length - 1][grid.length - 1];
		}
        
        for (int i = 1; i < grid.length ; i++) {
        	for (int j = 1; j < grid[0].length ; j++) {
        		grid[j][i] = grid[j][i] + min(grid[j - 1][i], grid[j][i - 1]);
        	}
        }
        
        
        return grid[grid[0].length - 1][grid.length - 1];
    }
	
	private static int min(int a, int b) {
		return (a < b)? a: b;
	}
}
