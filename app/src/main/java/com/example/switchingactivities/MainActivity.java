package com.example.switchingactivities;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.*;


import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus;
    private double co2Captured = 0;
    private int time;
    private int Co2ConsumptionPerYear;
    private LocalDate dateAdded;
    private LocalDate dateOfLastWater;
    private LocalDate dateOfNextWater;
    private LocalDate currentDate;
    private Date date;
    private String plantType = "Tree";
    private int incrementer;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureNextButton();

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLoadingText = (TextView) findViewById(R.id.LoadingCompleteTextView);

        if (plantType == "Tree") {
            incrementer = 7;
            Co2ConsumptionPerYear = 48; // how much co2 is absorbed in pounds every year
        }

        dateAdded = setDate(16, 1, 2019);
        dateOfLastWater = setDate(14, 11,2019);
        dateOfNextWater = setDateOfNextWater(dateOfLastWater, incrementer);
        currentDate = LocalDate.now();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long mProgressStatusLong = ChronoUnit.DAYS.between(currentDate, dateOfNextWater);
                mProgressStatus = (int) mProgressStatusLong;
                mProgressBar.setProgress(mProgressStatus);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

        updateDaysLeft(currentDate, dateOfNextWater);
        updateCo2Absorbed(dateAdded, Co2ConsumptionPerYear, co2Captured);
    }

    private void updateDaysLeft(LocalDate currentDate, LocalDate dateOfNextWater) {
        long x = ChronoUnit.DAYS.between(currentDate, dateOfNextWater);
        int xInt = (int) x;

        final TextView daysLeftText = (TextView) findViewById(R.id.LoadingCompleteTextView);
        daysLeftText.setText(x + " Days till next water");
    }

    private void updateCo2Absorbed(LocalDate dateAdded, int Co2ConsumptionPerYear, double co2Captured) {
        long daysPlantAdded = ChronoUnit.DAYS.between(dateAdded, currentDate);
        float co2CapturedPerDay = (float) Co2ConsumptionPerYear / 365;
                //(float) daysPlantAdded;
        co2Captured = co2CapturedPerDay * daysPlantAdded;
        System.out.println("co2CapturedPerDay: "+ co2CapturedPerDay);
        System.out.println("co2Captured: "+ co2Captured);
        System.out.println("daysPlantAdded: "+ daysPlantAdded);
        final TextView changingText = (TextView) findViewById(R.id.text_to_change);
        int co2CapturedDouble = (int) co2Captured;
        String stringCo2Captured = String.valueOf(co2CapturedDouble);
        changingText.setText(stringCo2Captured);

    }


    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    } // configureNextButtion


    private LocalDate setDate(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    private LocalDate setDateOfNextWater(LocalDate dateOfLastWater, int increment) {
        dateOfNextWater = dateOfLastWater.plusDays(increment);
        return dateOfNextWater;
    }
}
