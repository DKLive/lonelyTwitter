/*
 * Important Tweet
 *
 * Version 1.5
 *
 * February 1, 2018
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
 */
public class ImportantTweet extends Tweet {
    /**
     * Creates an ImportantTweet object.
     * @param message Important tweet message
     */
    ImportantTweet(String message){
        super(message);
    }

    /**
     * Creates an ImportantTweet object.
     * @param message Important tweet message
     * @param date Important tweet date
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Checks if tweet is important.
     * @return boolean value when boolean is false
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
