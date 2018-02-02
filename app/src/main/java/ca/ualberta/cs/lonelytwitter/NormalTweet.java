/*
 * Normal Tweet
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

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * @author Dinesh
 * @version 1.5
 * @see Tweet
 *
 */
public class NormalTweet extends Tweet {
    /**
     * Creates a NormalTweet object with message.
     * @param message Normal tweet message
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Creates another NormalTweet object with message and date.
     *
     * @param message Tweet message
     * @param date Normal tweet date
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * This checks whether if tweet is important.
     * @return boolean value when boolean is false
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
