package com.example.plantproj;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class plantResultsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantresult_layout);




        String plantInfo = MLActivity.plantResults.get(0);
        configureResults(plantInfo);
        MLActivity.plantResults.clear();






    }


    private void configureResults(String plantinfo) {
        TextView resultText = (TextView) findViewById(R.id.resultBox);
        resultText.setText(plantinfo);
    }


}
