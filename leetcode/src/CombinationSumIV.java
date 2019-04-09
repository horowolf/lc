import java.util.LinkedList;

public class CombinationSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 2, 1};
		System.out.println(combinationSum4(a, 32));
	}
	
	public static int combinationSum4(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
		int[] bucket = new int[target + 1]; // combination bases
		bucket[0] = 1;
		
		// this loop: 1ms
		for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                	bucket[i] += bucket[i - nums[j]];
                }
               
            }
        }
		/* this loop: 300ms
		for (int i = 1; i <= target; i++) { // temp_target
			for (int j = 0; j < i; j++) { // value to add element of nums
				for (int a : nums) {
					if (j + a == i) {
						bucket[i] += bucket[j];
					}
				}
			}
		}
		
		/* Time Limit Exceeded
        LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i : nums) {
			if (i < target) {
				queue.addLast(i);
			} else if (i == target) {
				result++;
			}
			
		}
        while (queue.size() > 0) {
        	int popup = queue.pollFirst();
        	for (int i : nums) {
        		int buf = popup + i;
        		if (buf == target) {
        			result++;
        		} else if (buf < target) {
        			queue.addLast(buf);
        		}
        	}
        }
        */
		return bucket[target];
    }

}
