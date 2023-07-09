package Heaps.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter {
    private HashMap<Integer, HashSet<Integer>> followerList;
    private HashMap<Integer, TweetList> tweets;
    // we need this count to compare the timing to 2 tweets
    // higher the count more the recency of the tweet
    private int time;
    public DesignTwitter() {
        followerList = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    // to post a tweet we need to create a (key, value) mapping between 
    // the userId and tweets of a person ( since they can tweet multiple tweets)
    // we will be using hashMap of tweetId to list of tweets
    // since new tweets are will anyways in order we will be using hashMap<tweetId, tweets> only
    // time compelxity : O(1)
    public void postTweet(int userId, int tweetId) {
        tweets.compute(userId, (key, value)-> value == null ? new TweetList() : value).addTweet(time, tweetId);
        time++;
    }
    
    // since we want to use get the latest 10 tweets in the news feed
    // brute force would be to from the tweets of followersId get the 
    // latest tweet and every comparison
    // if he has k followers , time complexity : O(10* k)

    // we could do this in a better way by the same approach as merge k sorted Lists
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((x, y)-> y.time - x.time);
        List<Integer> feed = new ArrayList<>();
    
        for ( int followeeId : followerList.getOrDefault(userId, new HashSet<>())){
            if (tweets.get(followeeId) != null && tweets.get(followeeId).getLatestTweet() != null )
                pq.add(tweets.get(followeeId).getLatestTweet());
        }
        // also add his own tweets to the pq if he has made any tweets
        if ( tweets.get(userId) != null && tweets.get(userId).getLatestTweet() != null)
            pq.add(tweets.get(userId).getLatestTweet());

        int feedLen = 0;
        while( feedLen < 10 && !pq.isEmpty() ){
            Tweet currTweet = pq.poll();
            feed.add(currTweet.tweetId);
            feedLen++;
            if ( currTweet.next != null ){
                pq.offer(currTweet.next);
            }

        }
        return feed;
    }
    // intuition : we need to create a datastructure which contains a mapping
    // of an id to its follower's list
    // as hashMap of id : list comes to mind
    // but it has linear time complexity for add and delete operations
    // for follow and unfollow we will use a hashMap of <Integer, Set>
    // since it will allow use to do these operations in constant time
    // time complexity : O(1)
    public void follow(int followerId, int followeeId) {
        followerList.compute(followerId, (k, v)-> v == null ? new HashSet<>() : v).add(followeeId);
    }
    // time complexity : O(1)
    public void unfollow(int followerId, int followeeId) {
            followerList.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

class TweetList{
    private Tweet dummyHead;
    public TweetList(){
        dummyHead = new Tweet(-1, Integer.MIN_VALUE);
    }

    public void addTweet(int time, int tweetId){

        Tweet currTweet = new Tweet(time, tweetId);
        currTweet.next = dummyHead.next;
        dummyHead.next = currTweet;
    }

    public Tweet getLatestTweet(){
        return dummyHead.next;
    }

}

class Tweet{
    int time;
    int tweetId;
    Tweet next;
    public Tweet(int time, int tweetId){
        this.time = time;
        this.tweetId = tweetId;
        next = null;
    }
}