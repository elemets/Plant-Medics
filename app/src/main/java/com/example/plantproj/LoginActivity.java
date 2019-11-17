package com.example.plantproj;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        configureNextButton();



    }




    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.loginbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, plantActivity.class));
            }
        });
    } // configureNextButtion

}