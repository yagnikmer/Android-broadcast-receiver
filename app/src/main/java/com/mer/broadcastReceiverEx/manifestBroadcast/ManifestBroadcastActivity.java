package com.mer.broadcastReceiverEx.manifestBroadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mer.broadcastReceiverEx.R;

public class ManifestBroadcastActivity extends Activity {

    String FILTER = "com.mer.broadcasttrigger";
    public static final String TAG = "AppFlow";
    IntentFilter intentFilter = new IntentFilter(FILTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    protected void broadcastClick(View view) {
        Intent intent = new Intent();
        intent.setAction(FILTER);
        intent.putExtra("msg", "Yagnik M");
        sendBroadcast(intent);
    }
}
