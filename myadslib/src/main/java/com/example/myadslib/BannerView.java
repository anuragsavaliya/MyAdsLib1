package com.example.myadslib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Created by Anurag Savaliya on 20-May-21.
 */
public class BannerView extends LinearLayout {
    public BannerView(Context context) {
        super(context);
        initAds();
    }


    public BannerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAds();
    }

    public BannerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAds();
    }

    public void initAds() {
        new BannerAdClass(getContext(), this);
    }

}
