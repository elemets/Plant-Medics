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
        String plantWiki= Backend.wikiFinal;

        // String plantWiki = MLActivity.W
        configureResults(plantInfo);
        configureWiki(plantWiki);

        MLActivity.plantResults.clear();
        Backend.plantWikis.clear();






    }


    private void configureResults(String plantinfo) {
        TextView resultText = (TextView) findViewById(R.id.resultBox);
        resultText.setText(plantinfo);
    }

    private void configureWiki(String wikiinfo) {
        TextView resultWiki = (TextView) findViewById(R.id.wikiBox);
        resultWiki.setText(wikiinfo);
    }


}
