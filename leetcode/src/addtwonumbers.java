


class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
public class addtwonumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
		//l1.next = new ListNode(0);
		//l1.next.next = new ListNode(2);
		
		ListNode l2 = new ListNode(5);
		//l2.next = new ListNode(8);
		//l2.next.next = new ListNode(4);
		
		ListNode n = addtwonumbers(l1, l2);
		
		
		System.out.println("End");

	}
	public static ListNode addtwonumbers (ListNode l1, ListNode l2){
		ListNode ans = new ListNode(0);
		ListNode ansN = ans;
		int carry = 0;
		do {
			int s = l1.val + l2.val + carry;
			carry = 0;
			if (s >= 10) {
				s -= 10;
				carry = 1;
			}
			ansN.next = new ListNode(s);
			ansN = ansN.next;
			l1 = l1.next;
			l2 = l2.next;
		} while (l1 != null && l2 != null);
		int s = 0;
		int k = 0;
		do {
			s =0;
			k = 1;
			if (l1 != null) {
				s += l1.val;
				l1 = l1.next;
				k = 0;
			}
			if (l2 != null) {
				s += l2.val;
				l2 = l2.next;
				k = 0;
			} 
			if (carry == 1) {
				s += carry;
				carry = 0;
				k = 0;
			}
			if (s >= 10) {
				s -= 10;
				carry = 1;
			}
			if (s > 0 || carry > 0) {
                ansN.next = new ListNode(s);
			    ansN = ansN.next;
            } else if (k == 0) {
            	ansN.next = new ListNode(0);
			    ansN = ansN.next;
            }
		} while (k == 0);
		
		
		 
		return ans.next;
	}

}
