
public class BestTimeBuyandSellStockEasy {
	public int maxProfit(int[] prices) { // 121
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
	
	public int totalMaxProfit(int[] prices) { // 122
		if (prices.length < 2) {
			return 0;
		}
        int result = 0; // current max profit
        int profit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i - 1] > prices[i]) {
        		buyPrice = prices[i];
        		result += profit;
        		profit = 0;
        	} else if (prices[i] - buyPrice > profit) {
        		profit = prices[i] - buyPrice;
        	}
        	
        }
        result += profit;
        
		return result;
    }
}
