
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findMin(int[] nums) {
		if (nums.length == 0) {
			return 0; //?
		} else if (nums.length == 1) {
			return nums[0];
		}
		
		int head = 0;
		int end = nums.length - 1;
		int mid = (head + end) / 2; // may == head
		if (nums[head] < nums[end]) {
			return nums[head];
		}
		while (end - head > 1) {
			/*
			if (nums[head] > nums[head + 1]) {
				return nums[head + 1];
			}
			*/
			if (nums[head] > nums[mid]) {
				end = mid;
				mid = (head + end) / 2;
			} else if (nums[mid] > nums[end]) {
				head = mid;
				mid = (head + end) / 2;
			} else {
				return nums[head]; // maybe next to head?
			}
		}
		
		return (nums[head]<nums[end])? nums[head]: nums[end]; //or head?
    }

}
