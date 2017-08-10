package com.mywallpaper.modules;

import android.app.WallpaperManager;
import android.graphics.Bitmap;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.IOException;

/**
 * Created by tinhngo on 10/08/2017.
 */

public class WallpaperAndroid extends ReactContextBaseJavaModule{

    private WallpaperManager myWallpaperManager;
    private ReactApplicationContext mApplicationContext;

    public WallpaperAndroid(ReactApplicationContext reactContext) {
        super(reactContext);
        mApplicationContext = getReactApplicationContext();
        myWallpaperManager = WallpaperManager.getInstance(mApplicationContext);
    }

    @Override
    public String getName() {
        return "WallpaperAndroid";
    }

    @ReactMethod
    public void setWallpaper(Bitmap bitmap) {
        try {
            myWallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
