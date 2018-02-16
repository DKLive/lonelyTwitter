package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Dinesh on 14/02/18.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }



    public void testDeleteTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("add Tweet");
        tweets.add(tweet);
        ArrayList<Tweet> countAllList = tweets.getAllTweet();
        assertEquals(countAllList.size(),tweets.tweetSize());
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
        Tweet tweet = new NormalTweet("adding normal tweet");
        tweets.add(tweet);
        Tweet tweet2 = new NormalTweet("adding second normal tweet");
        tweets.add(tweet2);
        tweetList.add(tweet);
        tweetList.add(tweet2);
        ArrayList<Tweet> returnTweetList = tweets.getTweet();
        assertEquals(returnTweetList, tweetList);
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        try{
            tweets.add(tweet);
        }

        catch(Exception e){
            assertEquals("tweets load", e);
        }
    }
}
