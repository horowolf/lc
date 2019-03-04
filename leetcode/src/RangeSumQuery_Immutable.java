
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
	int sum = 0;
    public NumArray(int[] nums) {
        array = nums;
    }
    
    public int sumRange(int i, int j) {
        
    	for (int a = i; a<= j; a++) {
    		sum += array[a];
    	}
    	
    	int r = sum;
    	sum = 0;
    	return r;
    }
}