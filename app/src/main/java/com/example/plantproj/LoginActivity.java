package com.example.plantproj;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {

    public static List<String> plantDatabase = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        configureNextButton();
        plantDatabase.add("Dracena");
        plantDatabase.add("Monstera Deliciosa");
        plantDatabase.add("Hectors Spinefiled");
        plantDatabase.add("Red Marram");
        plantDatabase.add("Cactus");



    }




    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.loginbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MapsActivity.class));
            }
        });
    } // configureNextButtion

}