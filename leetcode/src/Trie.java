import java.util.HashMap;

public class Trie { // Q 208
	TrieNode root;
	
	
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode current = root;
        for (int n = 0; n < word.length(); n++) {
        	if (current.map.containsKey(String.valueOf(word.charAt(n)))) {
        		current = current.map.get(String.valueOf(word.charAt(n)));
        	} else {
        		TrieNode node = new TrieNode();
        		current.map.put(String.valueOf(word.charAt(n)), node);
        		current = current.map.get(String.valueOf(word.charAt(n)));
        	}
        }
        current.map.put("End", null);
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode current = root;
        for (int n = 0; n < word.length(); n++) {
        	if (current.map.containsKey(String.valueOf(word.charAt(n)))) {
        		current = current.map.get(String.valueOf(word.charAt(n)));
        	} else {
        		return false;
        	}
        }
        if (current.map.containsKey("End")) {
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode current = root;
        for (int n = 0; n < prefix.length(); n++) {
        	if (current.map.containsKey(String.valueOf(prefix.charAt(n)))) {
        		current = current.map.get(String.valueOf(prefix.charAt(n)));
        	} else {
        		return false;
        	}
        }
        return true;
    }
    
    class TrieNode {
    	HashMap<String, TrieNode> map;
    	protected TrieNode() {
    		map = new HashMap<String, TrieNode>();
    	}
    }
}
