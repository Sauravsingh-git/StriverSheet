package Heaps.Hard;

import java.util.HashMap;

public class DesignTwitter {
    private HashMap<Integer, TweetList> tweets;
    int time = 0;
    public DesignTwitter(){
        tweets = new HashMap<>();

    }
    public static void main(String [] args){
        
        DesignTwitter obj = new DesignTwitter();
        obj.postTweet(1, 3);
        obj.postTweet(1, 5);
    }

    public void postTweet(int userId, int tweetId) {
  
        tweets.compute(userId, (key, value)-> value == null ? new TweetList() : value).addTweet(time, tweetId);
        time++;
        System.out.println(tweets.toString());
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
        printList();
    }

    public void printList(){
        Tweet currNode = dummyHead.next;
        while ( currNode != null ) {
            System.out.print(currNode.tweetId + " ");
            currNode = currNode.next;
        }
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
