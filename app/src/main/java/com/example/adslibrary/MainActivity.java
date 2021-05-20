package com.example.adslibrary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myadslib.AdsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AdsManager adsManager = new AdsManager();
        adsManager.setGoogleBanner("ca-app-pub-3940256099942544/6300978111");


        setContentView(R.layout.activity_main);


    }
}