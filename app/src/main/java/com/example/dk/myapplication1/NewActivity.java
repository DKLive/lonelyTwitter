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

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class NewActivity extends MainActivity  {

    private static final String FILENAME = "list.sav";
    private static int total_S = 0;
    ListView listview1;
    public static ArrayList<MainActivity> listArrayList = new ArrayList<MainActivity>();
    public static ArrayAdapter<MainActivity> listAdapter1;

    /**
     * Creates Oncreate function that displays the subscription information in a listview
     *
     *
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            // Activity was brought to front and not created,
            // Thus finishing this will get us to the last viewed activity
            finish();
            return;
        }

        setContentView(R.layout.new_activity);

        final TextView tcost = (TextView) findViewById(R.id.totalCost);

        listview1 = (ListView) findViewById(R.id.listview1);

        listAdapter1 = new ArrayAdapter<MainActivity>(this,R.layout.list_item,listArrayList);

        Intent i = getIntent();
        MainActivity obj1 =  (MainActivity) i.getSerializableExtra("mylist");

        if (obj1 != null) {
            setResult(RESULT_OK);
            total_S=total_S+obj1.getIvalue();
            tcost.setText(Integer.toString(total_S));
            listview1.setAdapter(listAdapter1);
            listArrayList.add(obj1);
            listAdapter1.notifyDataSetChanged();
           // saveInFile();
        }

        Intent in = getIntent();
        MainActivity objm = (MainActivity) in.getSerializableExtra("mylistn");

        if (objm != null) {
            total_S+=objm.getIvalue();
            tcost.setText(Integer.toString(total_S));

            listview1.setAdapter(listAdapter1);
            listArrayList.add(objm);


            listAdapter1.notifyDataSetChanged();
        }

        Intent i2 = getIntent();
        final MainActivity obj5 = (MainActivity) i2.getSerializableExtra("mylist2");
        if (obj5 != null) {
            MainActivity objb = listAdapter1.getItem(obj5.getPvalue());
             objb.setName(obj5.getName());
             objb.setIvalue(obj5.getIvalue());
             objb.setComment(obj5.getComment());
            objb.setDate(obj5.getDate());

            total_S+=objb.getIvalue();
            tcost.setText(Integer.toString(total_S));

            listview1.setAdapter(listAdapter1);
            listAdapter1.notifyDataSetChanged();
           // saveInFile();

        }

        Button button_w = (Button) findViewById(R.id.button12);
        button_w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(NewActivity.this, MainActivity.class);
                k.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(k);


            }
        });


        /**
         * gives user 3 options to edit, delete, or reset subscription value
         *
         *
         */

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                   final int position, long id)
            {
                AlertDialog.Builder adb=new AlertDialog.Builder(NewActivity.this);
                adb.setTitle("Reset/Edit/Delete?");
                adb.setMessage("Do you want to update " + getName());
                final int positionToRemove = position;
                adb.setNeutralButton("Reset", new AlertDialog.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        MainActivity objc = listAdapter1.getItem(position);
                        listAdapter1.notifyDataSetChanged();

                    }
                });
                adb.setNegativeButton("Delete",
                        new AlertDialog.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                MainActivity obj11 = listAdapter1.getItem(position);
                                total_S-=obj11.getIvalue();
                                tcost.setText(Integer.toString(total_S));

                                listArrayList.remove(position);
                                listAdapter1.notifyDataSetChanged();

                            }
                        });
                adb.setPositiveButton("Edit", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity obj2 = listAdapter1.getItem(position);
                        obj2.setPvalue(position);
                        total_S-=obj2.getIvalue();
                        tcost.setText(Integer.toString(total_S));
                        Intent newIntent = new Intent();
                        newIntent.setClass(NewActivity.this, NewActivity2.class);
                        newIntent.putExtra("mylist1", obj2);
                        startActivity(newIntent);

                        listAdapter1.notifyDataSetChanged();
                       // saveInFile();
                    }});
                adb.show();

            }

            public void onNothingSelected(AdapterView parentView) {

            }
        });

    }



    @Override
    public String toString() {
        return this.getName() + "  " + this.getIvalue() + "  " + this.getComment()+ "  " + this.getDate() ;
    }


    @Override
    protected void onStart() {

        // TODO Auto-generated method stub
        super.onStart();
        Log.i("LifeCycle --->", "onStart is called");

       /* loadFromFile();

        listAdapter1 = new ArrayAdapter<MainActivity>(this,R.layout.list_item,listArrayList);
        listview1.setAdapter(listAdapter1);*/

    }

    /**
     * loads the file where, the user saved his string array representation of an object
     *
     *
     */

    public void loadFromFile(){

        try {

            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<MainActivity>>(){}.getType();

            listArrayList = gson.fromJson(in, listType);



        } catch (FileNotFoundException e) {

            listArrayList = new ArrayList<MainActivity>();

        } catch (IOException e) {

            throw new RuntimeException();

        }
    }


    /**
     * saves object array as string representation in a file
     *
     *
     */
    public  void saveInFile( ){

        try {

            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(listArrayList, out);
            out.flush();

        } catch (FileNotFoundException e) {

            throw new RuntimeException();

        } catch (IOException e) {

            throw new RuntimeException();

        }



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy is called");
    }
}
