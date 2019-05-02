
public class FindFirstandLastPositioninSortedArray {
	
	public static void main(String[] args) {
		int[] n = new int[]{5,7,7,8,8,10};
		System.out.println(searchRange(n, 8));
	}
	public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        if (nums.length == 0) {
        	return result;
        }
        
        if (nums[0] > target || nums[nums.length - 1] < target) {
        	return result;
        }
        
        if (nums[0] == target) {
        	result[0] = 0;
        } else {
        	while (left < right) {
            	mid = (left + right) / 2;
            	if (nums[mid] >= target) {
            		right = mid;
            		continue;
            	}
            	if (nums[mid] < target) {
            		if (nums[mid + 1] == target) {
            			result[0] = mid + 1;
            			break;
            		}
            		if (nums[mid + 1] > target) {
            			break;
            		}
            		left = mid;
            	}
            }
        }
        
        left = 0;
        right = nums.length - 1;
        
        if (nums[nums.length - 1] == target) {
        	result[1] = nums.length - 1;
        } else {
        	while (left < right) {
            	mid = (left + right + 1) / 2;
            	if (nums[mid] <= target) {
            		left = mid;
            		continue;
            	}
            	if (nums[mid] > target) {
            		if (nums[mid - 1] == target) {
            			result[1] = mid - 1;
            			break;
            		}
            		if (nums[mid - 1] < target) {
            			break;
            		}
            		right = mid;
            	}
            }
        }
        
        return result;
    }
}
