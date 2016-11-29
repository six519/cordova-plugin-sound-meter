package com.ferdinandsilva.android;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SoundMeterPlugin extends CordovaPlugin {
    public static final String TAG = "SoundMeterPlugin";
    public static Context thisContext;
    public static SoundMeter soundMeter;

    public SoundMeterPlugin() {
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        SoundMeterPlugin.thisContext = cordova.getActivity().getApplicationContext();

        SoundMeterPlugin.soundMeter = new SoundMeter();
        SoundMeterPlugin.soundMeter.start();

    }
    

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if ("getAmplitude".equals(action)) {
            callbackContext.success(SoundMeterPlugin.soundMeter.getAmplitude());
        } else {
            return false;
        }

        return true;    
    }

    public void onResume(boolean multitasking) {
        SoundMeterPlugin.soundMeter.start();
    }

    public void onPause(boolean multitasking) {
        SoundMeterPlugin.soundMeter.stop();
    }

    public void onDestroy() {
        SoundMeterPlugin.soundMeter.stop();
    }

}