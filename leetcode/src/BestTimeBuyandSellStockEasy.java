
public class BestTimeBuyandSellStockEasy {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
        int result = 0; // current max profit
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	if (buyPrice > prices[i]) {
        		buyPrice = prices[i];
        	} else if (prices[i] - buyPrice > result) {
        		result = prices[i] - buyPrice;
        	}
        	
        }
        
		return result;
    }
}
