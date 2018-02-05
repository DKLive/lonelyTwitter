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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * @author Dinesh
 * @version 1.5
 * @see NewActivity
 * @see NewActivity2
 * @see DatePickerFragment
 * @see DatePickerFragment2
 */

public class MainActivity extends AppCompatActivity implements Serializable  {


    private String name;

     private String date;
    private int i_value;
    private int p_value;
    private String comment;


    /**
     * Creates class for object to be used
     *
     *
     */
    public MainActivity(){
        this.name = " ";
        this.i_value = 0;
        this.comment = " ";
        this.p_value = 0;

    }

    /**
     * Creates class for objects with data to be used
     *
     *
     */

    public MainActivity(String name,  int i_value,int p_value, String comment, String date){
        this.name = name;
        this.p_value = p_value;
        this.i_value = i_value;
        this.comment = comment;
        this.date = date;
    }


    /**
     * getters and setters for member variables
     *
     *
     */
    public void setName ( String name ) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDate (  String date ) {this.date = date;}
    public String getDate() {return date;}

    public void setIvalue ( int i_value ) {
        this.i_value = i_value;
    }
    public int getIvalue() {
        return i_value;
    }

    public void setComment ( String comment ) {
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }

    public void setPvalue ( int p_value ) {
        this.p_value = p_value;
    }
    public int getPvalue() {
        return p_value;
    }


    /**
     * Creates Oncreate function whereby user inputs data
     *
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       final EditText text1 = (EditText) findViewById(R.id.editText);
       final EditText text4 = (EditText) findViewById(R.id.editText4);
        final EditText text5 = (EditText) findViewById(R.id.editText5);
        final EditText text2 = (EditText) findViewById(R.id.editText2);

        Button button_p = (Button) findViewById(R.id.button12);
        button_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = text1.getText().toString();
                i_value = Integer.parseInt(text4.getText().toString());
                comment = text5.getText().toString();
                date = text2.getText().toString();
                MainActivity obj = new MainActivity(name,i_value,p_value,comment,date);

                Intent myIntent = new Intent();
                myIntent.setClass(MainActivity.this, NewActivity.class);
                myIntent.putExtra("mylist", obj);
                startActivity(myIntent);

            }
        });


        Button button_q = (Button) findViewById(R.id.button2);
        button_q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                text4.setText("");
                text5.setText("");
                name = " ";
               date = " ";
                i_value = 0;
                comment = " ";
                // Do something in response to button click

            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


    /**
     * Creates datepicker so user can select date with ease
     *
     *
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /**
     * changes string representation of listview to look decnt
     *
     *
     */
    @Override
    public String toString() {
        return "Name: " +this.name + " \nMonthly Charge: $" + this.i_value + " \nComment: " + this.comment + " \nDate: " + this.date ;
    }


}
