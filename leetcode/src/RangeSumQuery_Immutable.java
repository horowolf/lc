
public class RangeSumQuery_Immutable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
		NumArray obj = new NumArray(a);
		int param_1 = obj.sumRange(1,4);
		System.out.println(param_1);
	}
	
}

class NumArray {
	int[] array;
    public NumArray(int[] nums) {
        array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
        	array[i + 1] = array[i] + nums[i];
        }
        
    }
    
    public int sumRange(int i, int j) {
    	return array[j + 1] - array[i];
    }
}