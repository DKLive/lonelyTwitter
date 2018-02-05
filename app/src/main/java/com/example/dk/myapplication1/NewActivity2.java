
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
package com.example.dk.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NewActivity2 extends NewActivity {


    /**
     * Creates Oncreate function to edit subscription values
     *
     *
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.layout_new);

        Intent i1 = getIntent();
       final MainActivity obj3 = (MainActivity) i1.getSerializableExtra("mylist1");

        final EditText n1 = (EditText) findViewById(R.id.name1);
        final EditText d1 = (EditText) findViewById(R.id.date2);
        final EditText i2 = (EditText) findViewById(R.id.ivalue1);
        final EditText co1 = (EditText) findViewById(R.id.comment1);


        n1.setText(obj3.getName());
        d1.setText(obj3.getDate());
        i2.setText(String.valueOf(obj3.getIvalue()));
        co1.setText(obj3.getComment());

        Button button_q1 = (Button) findViewById(R.id.clear1);
        button_q1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                n1.setText("");
                d1.setText("");
                i2.setText("");
                co1.setText("");
                obj3.setName("");
                obj3.setDate(" ");
                obj3.setIvalue(0);
                obj3.setComment("");

            }
        });



        Button button_p = (Button) findViewById(R.id.button123);
        button_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj3.setName(n1.getText().toString());
                obj3.setDate(d1.getText().toString());
                obj3.setIvalue(Integer.parseInt(i2.getText().toString()));
                obj3.setComment(co1.getText().toString());
                MainActivity obj4 = new MainActivity(obj3.getName(),obj3.getIvalue(),obj3.getPvalue(),obj3.getComment(),obj3.getDate());

                Intent mIntent = new Intent(NewActivity2.this, NewActivity.class);
                mIntent.putExtra("mylist2", obj4);
                startActivity(mIntent);


            }
        });



    }

    /**
     * Creates function to displaye datepicker for user input date
     *
     *
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}