
public class RotateFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxRotateFunction(int[] A) {
    	int result = 0;
    	int sum = 0;
    	int buf = 0;
    	
    	for (int i = 0; i < A.length; i++) {
    		sum += A[i];
    		buf += i * A[i];
    	}
    	result = buf;
    	for (int i = A.length - 1; i > 0; i--) {
    		buf = buf + sum - A.length * A[i];
    		result = (result > buf)? result: buf;
    	}
    	
        return result;
    }

}
