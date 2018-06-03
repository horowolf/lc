
public class GameofLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void gameOfLife(int[][] board) { // Q 289
		int[][] buf = new int[board.length][board[0].length];
        int sum = 0;
		
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				
				for (int b = j - 1; b <= j + 1 && b < board.length; b++) {
					if (b < 0) {
						b = 0;
					}
					for (int a = i - 1; a <= i + 1 && a < board[0].length; a++) {
						if (a < 0) {
							a = 0;
						}
						if (b == j && a == i) {
							continue;
						}
						sum += board[b][a];
					}
				}
				/*
				sum += board[j - 1][i - 1];
				sum += board[j - 1][i];
				sum += board[j - 1][i + 1];
				sum += board[j][i - 1];
				sum += board[j][i + 1];
				sum += board[j + 1][i - 1];
				sum += board[j + 1][i];
				sum += board[j + 1][i + 1];
				*/
				
				buf[j][i] = board[j][i];
				
				if (board[j][i] == 0) {
					if (sum == 3) {
						buf[j][i] = 1;
					}
				} else {
					if (sum < 2) {
						buf[j][i] = 0;
					} else if (sum > 3) {
						buf[j][i] = 0;
					}
				}
				
				sum = 0;
			}
		}
		
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				board[j][i] = buf[j][i];
			}
		}
		
    }
	
	
}
