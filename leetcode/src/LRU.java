import java.util.HashMap;

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
	//hashtree + link + capacity
	HashMap<Integer, LRUNode> cache;
	int size;
	LRUNode head = new LRUNode(-1, -1);
	LRUNode tail = new LRUNode(-2, -2);

    public LRUCache(int capacity) {
    	if (capacity > 0) {
    		size = capacity;
            cache = new HashMap<Integer, LRUNode>(capacity); //capacity?
            head.post = tail;
            tail.prev = head;
    	}
    }
    
    public int get(int key) {
    	if (size == 0) return -1;
    	if (cache.containsKey(Integer.valueOf(key))) {
    		//move to front
    		LRUNode buf = cache.get(Integer.valueOf(key));
    		//take out
    		buf.post.prev = buf.prev;
    		buf.prev.post = buf.post;
    		//insert to first;
    		buf.post = head.post;
        	head.post.prev = buf;
        	buf.prev = head;
        	head.post = buf;
        	return buf.value;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	if (size == 0) return;
        if (cache.containsKey(Integer.valueOf(key))) {
        	//move to front
        	LRUNode buf = cache.get(Integer.valueOf(key));
    		//take out
    		buf.post.prev = buf.prev;
    		buf.prev.post = buf.post;
    		//insert to first;
    		buf.post = head.post;
        	head.post.prev = buf;
        	buf.prev = head;
        	head.post = buf;
        	buf.update(value);
        } else {
        	//remove LRU node
        	if (cache.size() >= size) { // should only be "=="
        		//remove LRU
        		cache.remove(Integer.valueOf(tail.prev.key));
        		tail.prev.prev.post = tail;
        		tail.prev = tail.prev.prev;
        	}
        	//insert at front
        	LRUNode node = new LRUNode(key, value);
        	node.post = head.post;
        	head.post.prev = node;
        	node.prev = head;
        	head.post = node;
        	cache.put(Integer.valueOf(key), node);
        }
    }
}

class LRUNode {
	int key;
	int value;
	LRUNode prev;
	LRUNode post;
	public LRUNode (int key, int value) {
		this.key = key;
		this.value = value;
	}
	public void update (int value) {
		this.value = value;
	}
}