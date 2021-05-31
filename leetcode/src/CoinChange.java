
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coinChange(new int[]{2}, 3);
	}
	
	public static int coinChange(int[] coins, int amount) {
		int[] bucket = new int[amount + 1];
		
		for (int i = 1; i <= amount; i++) {
			bucket[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= amount; i++) {
			dpChange(coins, i, bucket);
		}
		if (bucket[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return bucket[amount];
    }
	
	private static void dpChange(int[] coins, int amount, int[] bucket) {
		int current = bucket[amount];
		int buf = 0;
		for (int i = 0; i < coins.length; i++) {
			if (amount - coins[i] < 0 || bucket[amount - coins[i]] == Integer.MAX_VALUE) {
				continue;
			}
			buf = bucket[amount - coins[i]] + 1;
			if (buf < current) {
				current = buf;
			}
		}
		bucket[amount] = current;
	}

}
