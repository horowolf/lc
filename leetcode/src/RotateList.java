


public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
        ListNode ans = null;
        int count = 0;
        ListNode hold = head;
        
        if (head == null || k == 0) {
        	return head;
        }
		
        while (true) {
        	count++;
        	if (hold.next != null) {
        		hold = hold.next;
        		continue;
        	}
        	hold.next = head;
        	hold = head;
        	break;
        }
        
        if (count <= k) {
        	k = k % count;
        }
        
        count -= k;
        
        while (count > 1) {
        	count--;
        	hold = hold.next;
        }
        ans = hold.next;
        hold.next = null;
        
		return ans;
    }
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}

}
