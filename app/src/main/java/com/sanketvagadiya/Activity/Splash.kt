package com.sanketvagadiya.Activity

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle

import com.sanketvagadiya.Constants.Constants

import com.sanketvagadiya.R


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (Constants.isNetworkConnected(applicationContext)) {
            try {
                Thread.sleep(Constants.SPLASH_SLEEP_TIME.toLong())
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }


}
