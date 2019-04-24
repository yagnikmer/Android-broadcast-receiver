package com.mer.broadcastReceiverEx.manifestBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "AppFlow";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, intent.getStringExtra("msg"));
    }
}
