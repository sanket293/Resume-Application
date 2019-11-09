package com.sanketvagadiya.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sanketvagadiya.Constants.Constants;

import com.sanketvagadiya.R;



public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Constants.isNetworkConnected(getApplicationContext())) {
            try {
                Thread.sleep(Constants.SPLASH_SLEEP_TIME);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
