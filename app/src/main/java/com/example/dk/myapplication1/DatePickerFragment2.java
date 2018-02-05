package com.example.dk.myapplication1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
/*
 * My app1
 *
 * Version 1.2
 *
 * February 3, 2018
 *
 * Copyright (c) 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the licence in the project. Otherwise please contact contact@abc.ca.
 */
import java.util.Calendar;

public class DatePickerFragment2 extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    /**
     * Creates datepicker through its fragment
     *
     *
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * representsation on how datepicker should output the date
     *
     *
     */
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        TextView tv2 = (TextView) getActivity().findViewById(R.id.date2);
        tv2.setText(" " + view.getDayOfMonth() + " - " + view.getMonth() + " - " + view.getYear());


    }
}
