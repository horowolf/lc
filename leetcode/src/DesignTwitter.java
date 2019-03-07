import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class DesignTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twitter obj = new Twitter();
		obj.postTweet(1,5);
		List<Integer> param_2 = obj.getNewsFeed(1);
		obj.follow(1,2);
		obj.postTweet(2, 6);
		obj.getNewsFeed(1);
		obj.unfollow(1,2);
		obj.getNewsFeed(1);
	}

}

class Twitter {
	LinkedList<Post> list;
	Hashtable<Integer, HashSet<Integer>> relation; // followee key --value--> follower set
    /** Initialize your data structure here. */
    public Twitter() {
        list = new LinkedList<Post>();
        relation = new Hashtable<Integer, HashSet<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	Post p = new Post();
    	p.userID = userId;
    	p.postID = tweetId;
        list.addFirst(p);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Iterator<Post> iter = list.iterator();
    	while (iter.hasNext() && result.size() < 10) {
    		Post p = iter.next();
    		if (p.userID == userId) {
    			result.add(p.postID);
    			continue;
    		}
    		if (relation.containsKey(p.userID) && relation.get(p.userID).contains(userId)) {
    			result.add(p.postID);
    		}
    	}
    	
    	return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	HashSet<Integer> set = relation.get(followeeId);
    	if (set == null) {
    		set = new HashSet<Integer>();
    	}
    	set.add(followerId);
        relation.put(followeeId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	HashSet<Integer> set = relation.get(followeeId);
    	if (set != null) {
    		set.remove(followerId);
    		relation.put(followeeId, set);
    	}
    }
    
    class Post {
    	int userID;
    	int postID;
    }
}