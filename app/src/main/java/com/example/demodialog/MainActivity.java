package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1,btnDemo2,btnDemo3,btnDemo5,btnDemo6,ex3;
    TextView tvDemo2,tvDemo3,tvDemo4,tvDemo5,tvDemo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        btnDemo6 = findViewById(R.id.buttonDemo6);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        tvDemo6 = findViewById(R.id.textViewDemo6);
        ex3 = findViewById(R.id.buttonDemo4);

        btnDemo1.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick (View view){
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                 */


                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }

        });

        btnDemo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);
                //Configuring of the 'positive' button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvDemo2.setText("You have selected Positive.");

                            }
                        });

                     myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tvDemo2.setText("You have selected Negative.");

                        }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }

        });

        btnDemo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                //Inflates the input.xml layout file
                LayoutInflater inflater  =
                        (LayoutInflater) getSystemService((Context.LAYOUT_INFLATER_SERVICE));
                View viewDialog = inflater.inflate(R.layout.input, null);
                //Obtains the UI component in the input.xml layout
                //It needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);//Sets the view of the dialog
                myBuilder.setTitle("Demo 3 Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //Extract the text entered by the user
                        String  message = etInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }

        });


        ex3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                //Inflates the input.xml layout file
                LayoutInflater inflater  =
                        (LayoutInflater) getSystemService((Context.LAYOUT_INFLATER_SERVICE));
                View viewDialog = inflater.inflate(R.layout.ex3, null);
                //Obtains the UI component in the input.xml layout
                //It needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editText1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editText2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);//Sets the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //Extract the text entered by the user
                        String output =etInput.getText().toString();
                        Double op = Double.parseDouble(output);
                        String output2 =etInput2.getText().toString();
                        Double op2 = Double.parseDouble(output2);
                        Double output3 = op + op2;
                        String output4 = Double.toString(output3);

                        //Set the text to the TextView
                        tvDemo4.setText("The sum is" + output4);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }

        });

        btnDemo5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                            tvDemo5.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) +"/" + year);
                        }
                    };
                //Create the Date Picker Dialog
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                            myDateListener, year, month, day);

                myDateDialog.show();


            }

        });

        btnDemo6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                //Create the Listener to set the date
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        tvDemo6.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, true);


                myTimeDialog.show();


            }

        });


    }
}