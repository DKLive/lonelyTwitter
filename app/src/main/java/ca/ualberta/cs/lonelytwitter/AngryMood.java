package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by deepu on 1/19/2018.
 */

public class AngryMood extends CurrentMood {
    AngryMood(String mood){
        super(mood);
    }

    AngryMood(String mood, Date date){
        super(mood,date);
    }

    public String M_response(){
        return "Angry :(";
    }

    @Override
    public Boolean isHappy() {
        return Boolean.FALSE;
    }
}
