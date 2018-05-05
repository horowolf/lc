


public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {1,3,5,6,9,13,14,18,20,21};
		int[] n2 = {2,4,8,10,11,15,17,19};
		

		System.out.println("start");

		System.out.println(findMedianSortedArrays(n1, n2));
		
		System.out.println("end");

	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int fullLength = nums1.length + nums2.length;
        if (fullLength == 0) {
        	return ans;
        }
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
            	return (nums2[(nums2.length -1) / 2]+ nums2[nums2.length / 2]) / 2.0;
            } else {
            	return nums2[nums2.length / 2];
            }
        } else if (nums2.length == 0) {
        	if (nums1.length % 2 == 0) {
            	return (nums1[(nums1.length - 1) / 2]+ nums1[nums1.length / 2]) / 2.0;
            } else {
            	return nums1[nums1.length / 2];
            }
        }
        
        
        if (fullLength == 2) {
    		return (nums1[0] + nums2[0]) / 2.0;
    	}
        if (fullLength <= 4) {
        	int[] a = new int[fullLength];
        	int at = 0;
        	int at1 = 0;
        	int at2 = 0;
        	for (; at < fullLength; at++) {
        		if (at2 == nums2.length) {
        			a[at] = nums1[at1];
        			at1++;
        		} else if (at1 < nums1.length && nums1[at1] < nums2[at2]) {
        			a[at] = nums1[at1];
        			at1++;
        		} else {
        			a[at] = nums2[at2];
        			at2++;
        		}
        	}
        	if (fullLength == 3) {
        		return a[1];
        	} else {
        		return (a[1] + a[2]) / 2.0;
        	}
        }
        
        int removed1 = 0;
        int removed2 = 0;
        int middle = (nums1.length + nums2.length + 1) / 2;
        int needRemoved = middle - 1;
        int totalRemoved = 0;
        int add = 0;
        int skip = 0;
        int another = 0;
        while (totalRemoved < needRemoved) {
        	add = (needRemoved - totalRemoved) / 2; // + 1?
        	int add1 = (removed1 + add < nums1.length) ? removed1 + add: nums1.length - 1;
        	int add2 = (removed2 + add < nums2.length) ? removed2 + add: nums2.length - 1;
        	if (nums1[add1] < nums2[add2]) {
        		removed1 = add1 + 1;
        		if (removed1 == nums1.length) {
        			removed1--;
        			skip = 1;
        			totalRemoved = removed1 + removed2 + 1;
        			add = needRemoved - totalRemoved;
        			removed2 += add;
        			if (add > 0) {
        				another = 1;
        			}
        			break;
        		}
        	} else {
        		removed2 = add2 + 1;
        		if (removed2 == nums2.length) {
        			removed2--;
        			skip = 2;
        			totalRemoved = removed1 + removed2 + 1;
        			add = needRemoved - totalRemoved;
        			removed1 += add;
        			if (add > 0) {
        				another = 1;
        			}
        			break;
        		}
        	}
        	totalRemoved = removed1 + removed2;
        }
        if (skip == 0 && another == 0) {
        	if (nums1[removed1] < nums2[removed2]) {
            	ans = nums1[removed1];
            	removed1++;
            } else {
            	ans = nums2[removed2];
            	removed2++;
            }
        } else {
        	if (skip == 1) {
        		ans = nums2[removed2];
        		removed2++;
        	} else {
        		ans = nums1[removed1];
        		removed1++;
        	}
        }
        
        //removed1++;
        //removed2++;
        if (removed1 >= nums1.length) {
        	skip = 1;
        } else if (removed2 >= nums2.length) {
        	skip = 2;
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
        	//System.out.println(ans);
        	//System.out.println(nums1[removed1]);
        	//System.out.println(nums2[removed2]);
        	int buf;
        	if (skip == 1) {
            	buf = nums2[removed2];
            } else if (skip == 2) {
            	buf = nums1[removed1];
            } else {
            	buf = (nums1[removed1] < nums2[removed2]) ? nums1[removed1] : nums2[removed2];
            }
        	
        	//System.out.println(buf);
        	ans = (ans + buf) / 2.0;
        }
        
        
        return ans;
    }
}


/*
double ans = 0;
		int halfLen = (nums1.length + nums2.length) / 2;
		int start1 = 1, start2 = 1;
		//int end1 = nums1.length - 1, end2 = nums2.length - 1;
		int hold = 0;
		int location = 0; // 1 = numms1, 2 = nums2;
		int node1 = 0;
		int node2 = 0;
		while (hold < halfLen) {
			int left = (halfLen - hold + 1) / 2;
			node1 = (start1 + left < nums1.length) ? start1 + left : nums1.length;
			node2 = (start2 + left < nums2.length) ? start2 + left : nums1.length;
			int pick1 = nums1[node1 - 1];
			int pick2 = nums2[node2 - 1];
			
			if (pick1 < pick2) {
				start1 = node1;
				location = 1;
			} else {
				start2 = node2;
				location = 2;
			}
			hold = start1 + start2;
			
		}
		System.out.println(start1);
		System.out.println(start2);
		System.out.println(node1);
		System.out.println(node2);
		
		if (location == 1) {
			start2--;
		} else {
			start1--;
		}
		
		node1--;
		node2--;
		
		if (nums1[start1] > nums2[start2]) {
			ans = nums1[start1]; // +1? (or diff for even and odd
			location = 1;
		} else {
			ans = nums2[start2]; // +1?
			location = 2;
		}
		System.out.println(ans);
		System.out.println(nums1.length + nums2.length);
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			int buf = 0;
			if (location == 1) {
				buf = (nums1[start1 + 1] < nums2[start2]) ? nums1[start1 + 1] : nums2[start2]; // or no "+1"?
			} else {
				buf = (nums1[start1] < nums2[start2 + 1]) ? nums1[start1] : nums2[start2 + 1]; // or no "+1"?
			}
			System.out.println(buf);
			
			ans = (ans + buf) / 2.0;
		}
		
		return ans;


*/
