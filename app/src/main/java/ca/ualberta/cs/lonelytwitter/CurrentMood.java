package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by deepu on 1/19/2018.
 */

public abstract class CurrentMood implements Mood {

    private String mood;
    private Date date;

    CurrentMood(String mood){
        this.mood = mood;
        date = new Date();
    }

    CurrentMood(String mood, Date date){
        this.mood = mood;
        this.date = date;

    }

    public String getMood(){
        return mood;
    }

    public void setMood(String mood) {
            this.mood = mood;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract Boolean isHappy();
}
