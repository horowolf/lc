import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {1,2,3,4,5};
		System.out.println(String.valueOf(maxProfit(price)));
	}
	
	public static int maxProfit(int[] prices) { // Q123
		int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i:prices) {
            sell2 = Math.max(sell2, i - buy2);
            buy2    = Math.min(buy2,    i - sell1);
            sell1 = Math.max(sell1, i - buy1);
            buy1    = Math.min(buy1,    i);
        }
        return sell2;
    }
	
	public int maxProfit(int k, int[] prices) { // Q188 
		int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
	

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}

/*
result = sell2 - buy2 + sell1 - buy1 = sell2 - buy1 + (sell1 - buy2)
level of easy to move forward: sell2 > buy2> sell1> buy1

original of this solution from discussion:
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){
            release2 = Math.max(release2, hold2+i);
            hold2    = Math.max(hold2,    release1-i);
            release1 = Math.max(release1, hold1+i);
            hold1    = Math.max(hold1,    -i);
        }
        return release2;


*/


/*  Memory Limit Exceeded

		if (k == 0) {
			return 0;
		}
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; i++) {
        	buy[i] = Integer.MAX_VALUE;
        }
		for (int i: prices) {
			for (int j = k - 1; j > 0; j--) {
				sell[j] = Math.max(sell[j], i - buy[j]);
				buy[j] = Math.min(buy[j], i - sell[j - 1]);
			}
			sell[0] = Math.max(sell[0], i - buy[0]);
			buy[0] = Math.min(buy[0], i);
		}
		
        
        return sell[k - 1];

*/