package com.example.myadslib;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Anurag Savaliya on 20-May-21.
 */
public class AdsManager {
    String googleBanner = "ca-app-pub-3940256099942544/6300978111";
    String googleNative;
    String goolgeInterstrial;
    String fbBanner = "VID_HD_16_9_46S_APP_INSTALL#YOUR_PLACEMENT_ID";
    String fbNative;
    String fbInterstrial;
    boolean isGoogleShow;
    boolean isFbShow;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    public String getGoogleBanner() {
        return googleBanner;
    }

    public void setGoogleBanner(String googleBanner) {
        this.googleBanner = googleBanner;
    }

    public String getGoogleNative() {
        return googleNative;
    }

    public void setGoogleNative(String googleNative) {
        this.googleNative = googleNative;
    }

    public String getGoolgeInterstrial() {
        return goolgeInterstrial;
    }

    public void setGoolgeInterstrial(String goolgeInterstrial) {
        this.goolgeInterstrial = goolgeInterstrial;
    }

    public String getFbBanner() {
        return fbBanner;
    }

    public void setFbBanner(String fbBanner) {
        this.fbBanner = fbBanner;
    }

    public String getFbNative() {
        return fbNative;
    }

    public void setFbNative(String fbNative) {
        this.fbNative = fbNative;
    }

    public String getFbInterstrial() {
        return fbInterstrial;
    }

    public void setFbInterstrial(String fbInterstrial) {
        this.fbInterstrial = fbInterstrial;
    }

    public boolean isGoogleShow() {
        return isGoogleShow;
    }

    public void setGoogleShow(boolean googleShow) {
        isGoogleShow = googleShow;
    }

    public boolean isFbShow() {
        return isFbShow;
    }

    public void setFbShow(boolean fbShow) {
        isFbShow = fbShow;
    }


    public void saveAll(Context context) {
        this.pref = context.getSharedPreferences("myadspref", MODE_PRIVATE);
        this.editor = this.pref.edit();


        editor.putString("adsobj", new Gson().toJson(this));
        editor.apply();
    }
}
