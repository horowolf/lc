import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findClosestElements(new int[]{0,0,0,1,3,5,6,7,8,8}, 2, 2);
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) { // x = target, k = kth number
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (x < arr[0]) {
			for (int i = 0; i < k; i++) {
				result.add(arr[i]);
			}
			return result;
		}
		if (x > arr[arr.length - 1]) {
			for (int i = 1; i <= k; i++) {
				result.addFirst(arr[arr.length - i]);
			}
			return result;
		}
		
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] == x) {
				result.add(arr[mid]);
				k--;
				break;
			}
			if (arr[mid] < x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		left = mid - 1;
		if (left < 0) {
			left = 0;
		}
		if (result.isEmpty()) {
			right = mid;
		} else {
			right = mid + 1;
		}
		
		int count = 0;
		
		while (count < k) {
			if (right >= arr.length) {
				result.addFirst(arr[left]);
				count++;
				left--;
				continue;
			}
			if (left < 0) {
				result.add(arr[right]);
				count++;
				right++;
				continue;
			}
			if (x - arr[left] > arr[right] - x) { // pick right only if left is far than right
				result.add(arr[right]);
				count++;
				right++;
			} else {
				result.addFirst(arr[left]);
				count++;
				left--;
			}
		}
		
        return result;
    }

}
