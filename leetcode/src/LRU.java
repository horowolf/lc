


public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 2;
		int key = 1;
		int value = 1;
		LRUCache obj = new LRUCache(capacity);
		int param_1 = obj.get(key);
		obj.put(key,value);
	}

}

class LRUCache { // Could you do both operations in O(1) time complexity? Q 146

    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        return 0; // need change
    }
    
    public void put(int key, int value) {
        
    }
}