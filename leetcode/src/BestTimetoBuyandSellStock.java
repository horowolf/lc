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
        for(int i:prices){
            sell2 = Math.max(sell2, i - buy2);
            buy2    = Math.min(buy2,    i - sell1);
            sell1 = Math.max(sell1, i - buy1);
            buy1    = Math.min(buy1,    i);
        }
        return sell2;
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