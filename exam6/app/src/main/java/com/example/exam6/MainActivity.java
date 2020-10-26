package com.example.exam6;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

//        // exam6_4 ~~~~ 6_9

//    Chronometer chrono;
//    Button btnStart, btnEnd;
//    RadioButton rdoCal, rdoTime;
//    CalendarView calView;
//    TimePicker tPicker;
//    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
//    int selectYear, selectMonth, selectDay;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.exam6_4);
//
//        btnStart = (Button) findViewById(R.id.btnStart);
//        btnEnd = (Button)  findViewById(R.id.btnEnd);
//
//        chrono = (Chronometer) findViewById(R.id.chronometer1);
//
//        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
//        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
//
//        tPicker = (TimePicker) findViewById(R.id.timePicker1);
//        calView = (CalendarView) findViewById(R.id.calendarView1);
//
//        tvYear = (TextView) findViewById(R.id.tvYear);
//        tvMonth = (TextView) findViewById(R.id.tvMonth);
//        tvDay = (TextView) findViewById(R.id.tvDay);
//        tvHour = (TextView) findViewById(R.id.tvHour);
//        tvMinute = (TextView) findViewById(R.id.tvMinute);
//
//        tPicker.setVisibility(View.INVISIBLE);
//        calView.setVisibility(View.INVISIBLE);
//
//        rdoCal.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                tPicker.setVisibility(View.INVISIBLE);
//                calView.setVisibility(View.VISIBLE);
//            }
//        });
//
//        rdoTime.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                tPicker.setVisibility(View.VISIBLE);
//                calView.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono.setBase(SystemClock.elapsedRealtime());
//                chrono.start();
//                chrono.setTextColor(Color.RED);
//            }
//        });
//
//        btnEnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono.stop();
//                chrono.setTextColor(Color.BLUE);
//
//                tvYear.setText(Integer.toString(selectYear));
//                tvMonth.setText(Integer.toString(selectMonth));
//                tvDay.setText(Integer.toString(selectDay));
//
//                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
//                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
//            }
//        });
//
//        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                selectYear = year;
//                selectMonth = month + 1;
//                selectDay = dayOfMonth;
//            }
//        });
//
//
//        tvYear.setText(Integer.toString(selectYear));
//        tvMonth.setText(Integer.toString(selectMonth));
//        tvDay.setText(Integer.toString(selectDay));
//
//        tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
//        tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
//
//    }
//}
//                              exam6_4 ~~~~~ 6_9 ()



    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;
    LinearLayout Lin1, Lin2;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam6test_1);


        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        dPicker = (DatePicker) findViewById(R.id.dPicker);
        Lin1 = (LinearLayout) findViewById(R.id.Lin1);
        Lin2 = (LinearLayout) findViewById(R.id.Lin1);

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lin1.setVisibility(View.VISIBLE);
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selectYear = year;
                selectMonth = monthOfYear;
                selectDay = dayOfMonth;
            }
        });

        Lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

        tvYear.setText(Integer.toString(selectYear));
        tvMonth.setText(Integer.toString(selectMonth));
        tvDay.setText(Integer.toString(selectDay));

        tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
        tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

    }
}
