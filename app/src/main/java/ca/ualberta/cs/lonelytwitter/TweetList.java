package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){
    }

    public void add(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("tweet load");
        }
        else{
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweet(){
        return tweets;
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }
}
