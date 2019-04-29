
public class FindPeakElement { // to find a peek => just find this graphic / \
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
        	return 0;
        }
        // check if edge is answer
        if (nums[0] > nums[1]) {
        	return 0;
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
        	return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;
        // edge is not answer => the element next to edge will increase => left is / and right is \
        
        while (true) {
        	int mid = (left + right) / 2;
        	if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // hit the target /\
        		return mid;
        	}
        	if (nums[mid] < nums[mid - 1]) { // at least one side of mid is increasing \ or / or \/
        		right = mid;
        	} else {
        		left = mid;
        	}
        }
        
        
    }
}
