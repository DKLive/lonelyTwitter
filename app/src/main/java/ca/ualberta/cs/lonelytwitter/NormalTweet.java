package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
