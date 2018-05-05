


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{ 1, 2, 3 } };
		System.out.println(spiralOrder(m));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0) {
        	return ans;
        } // hope this won't use
        int left = 0;
        int up = 0;
        int right = matrix[0].length;
        int down = matrix.length;
        
        for (int count = 0; count < matrix.length * matrix[0].length;) {
        	for (int i = left; i < right; i++) {
        		ans.add(matrix[up][i]);
        		count++;
        	}
        	up++;
        	for (int i = up; i < down; i++) {
        		ans.add(matrix[i][right - 1]);
        		count++;
        	}
        	right--;
        	if (left >= right) break;
        	if (up >= down) break;
        	for (int i = right - 1; i >= left; i--) {
        		ans.add(matrix[down - 1][i]);
        		count++;
        	}
        	down--;
        	if (left >= right) break;
        	if (up >= down) break;
        	for (int i = down - 1; i >= up; i--) {
        		ans.add(matrix[i][left]);
        		count++;
        	}
        	left++;
        }
		
        return ans;
    }

}
