package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TabHost;

import java.util.Calendar;

public class TabHostActivity extends AppCompatActivity {

    Button dateBtn, timeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        dateBtn = findViewById(R.id.dateBtn);
        timeBtn = findViewById(R.id.timeBtn);

//        CALENDER
        final Calendar mCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateSetListener;
        dateSetListener =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("tag", year+"-"+String.valueOf(month+1)+"-"+dayOfMonth);
            }
        };



//        TABHOST
        final TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec TS;
        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab1);
        TS.setIndicator("Set Date");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab2);
        TS.setIndicator("Set Time");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab3);
        TS.setIndicator("ListView");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab4);
        TS.setIndicator("About");
        tabHost.addTab(TS);

//      BUTTONS
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });



    }
}