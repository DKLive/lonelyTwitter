package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by deepu on 1/19/2018.
 */

public class HappyMood extends CurrentMood {
    HappyMood(String mood){
        super(mood);
    }

    HappyMood(String mood, Date date){
        super(mood,date);
    }

    public String M_response(){
        return "Happy :)";
    }

    @Override
    public Boolean isHappy() {
        return Boolean.TRUE;
    }
}
