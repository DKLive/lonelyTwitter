/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 * Copyright (c) 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the licence in the project. Otherwise please contact contact@abc.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is a tweet
 * @author Dinesh
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Creates a tweet object with message.
     * @param message tweet message
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
    }

    /**
     * Constructs a tweet object with message and date.
     * @param message tweet message
     * @param date tweet date
     */

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * obtains tweet message when requested.
     * @return Returns Tweet message
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets tweet message when requested.
     * @param message tweet message
     * @throws TweetTooLongException the tweet message if it is over 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Obtains the date when requested.
     * @return Date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets the date when requested.
     * @param date Date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * This checks whether if tweet is important.
     * @return Boolean value
     */
    public abstract Boolean isImportant();

    /**
     * This converts date to a string value in a particular way.
     * @return String
     */
    public String toString() {
        return date.toString() + " | " + message;
    }

}
