
public class GameofLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void gameOfLife(int[][] board) { // Q 289
		int[][] buf = new int[board.length][board[0].length];
        int sum = 0;
		
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				try {
					sum += board[j - 1][i - 1];
				} catch (Exception e) {
				}
				try {
					sum += board[j - 1][i];
				} catch (Exception e) {
				}
				try {
					sum += board[j - 1][i + 1];
				} catch (Exception e) {
				}
				try {
					sum += board[j][i - 1];
				} catch (Exception e) {
				}
				try {
					sum += board[j][i + 1];
				} catch (Exception e) {
				}
				try {
					sum += board[j + 1][i - 1];
				} catch (Exception e) {
				}
				try {
					sum += board[j + 1][i];
				} catch (Exception e) {
				}
				try {
					sum += board[j + 1][i + 1];
				} catch (Exception e) {
				}
				
				if (board[j][i] == 0) {
					if (sum == 3) {
						board[j][i] = 1;
					}
				} else {
					if (sum < 2) {
						board[j][i] = 0;
					} else if (sum > 3) {
						board[j][i] = 0;
					}
				}
				
				sum = 0;
			}
		}
		
		board = buf; // maybe need another loop
    }
	
	
}
