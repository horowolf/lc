import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {6,1,3,2,4,7};
		System.out.println(String.valueOf(maxProfit(price)));
	}
	
	public static int maxProfit(int[] prices) { // Q123
		if (prices.length < 2) {
			return 0;
		}
        int ans = 0;
		// Link-list
        LinkedList<LinklistNode> list = new LinkedList<LinklistNode>();
        //LinklistNode root = new LinklistNode(0, 0, 0);
        LinklistNode current = new LinklistNode(0, 0, 0);
        //root.next = current;
        int startDate = 0;
        int endDate = 0;
        int lowPrice = prices[0];
        int earning = 0;
        // for-loop to create candidate list
        // each candidate start from lower start price date, end at the date before lower start price date or null
        for (int i = 0; i < prices.length; i++) {
        	if (lowPrice > prices[i]) {
        		lowPrice = prices[i];
        		list.add(current);
        		current = new LinklistNode(0, i, i);
        		earning = 0;
        		continue;
        	}
        	if (prices[i] - lowPrice > earning) {
        		earning = prices[i] - lowPrice;
        		endDate = i;
        		current.update(earning, i);
        	}
        }
        list.add(current);
        // sort from high value to low value
        //LinklistNode[] a = new LinklistNode[list.size()]; // hope to have root.length
        Collections.sort(list, new Comparator<LinklistNode>() {
        	@Override
        	public int compare(LinklistNode a, LinklistNode b){
        		return b.val - a.val;
        	}
        });
        // pick highest node + highest pair node without intersection, and cut the rest
        startDate = list.getFirst().start;
        endDate = list.getFirst().end;
        int totalEarning = list.getFirst().val; // ans?
        int endForNextLoop = list.size();
        for (int i = 0; i < endForNextLoop; i++) {
        	earning = list.get(i).val;
        	for (int j = i; j < endForNextLoop; j++) {
        		if (startDate > list.get(j).end || endDate < list.get(j).start) {
            		if (totalEarning < earning + list.get(j).val) {
            			endForNextLoop = j + 1;
            			totalEarning = earning + list.get(j).val; 
            		}
            	}
        	}
        	
        }
        // find if any pair come with better profit. keep cut the rest?
        ans = totalEarning;
		return ans;
    }
}

class LinklistNode {
	int val;
	int start;
	int end;
	//LinklistNode next;
	protected LinklistNode(int earning, int buy, int sell) {
		val = earning;
		start = buy;
		end = sell;
	}
	protected void update(int earning, int sell) {
		val = earning;
		end = sell;
	}
}