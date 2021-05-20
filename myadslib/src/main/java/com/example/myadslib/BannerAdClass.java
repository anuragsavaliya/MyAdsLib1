package com.example.myadslib;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

/**
 * Created by Anurag Savaliya on 20-May-21.
 */
public class BannerAdClass {
    private static final String TAG = "bannerads";
    AdsManager adsManager;
    private Context context;
    private LinearLayout adMainLayout;
    private FrameLayout adsContainer;
    private com.facebook.ads.AdView adViewfb;

    public BannerAdClass(Context context, LinearLayout adMainLayout) {
        this.context = context;
        this.adMainLayout = adMainLayout;

        Log.d(TAG, "BannerAdClass: ");

        initAds();

    }

    private void initAds() {
        Log.d(TAG, "initAds: ");
        AdView adView = new AdView(context);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111p");
        adView.setAdSize(AdSize.FULL_BANNER);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d(TAG, "onAdFailedToLoad: google banner " + i);

            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.d(TAG, "onAdFailedToLoad: google banner " + loadAdError);
                initFacebook();

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d(TAG, "onAdLoaded: google banner");
                adMainLayout.removeAllViews();
                adMainLayout.addView(adView);
            }

        });
        adView.loadAd(new AdRequest.Builder().build());
    }

    private void initFacebook() {
        adViewfb = new com.facebook.ads.AdView(context, "VID_HD_16_9_46S_APP_INSTALL#YOUR_PLACEMENT_ID", com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        adViewfb.loadAd(adViewfb.buildLoadAdConfig().withAdListener(new com.facebook.ads.AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d(TAG, "onError: facebook banner " + adError);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d(TAG, "onAdLoaded: facebook banner");
                adMainLayout.removeAllViews();
                adMainLayout.addView(adViewfb);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        }).build());

    }
}
