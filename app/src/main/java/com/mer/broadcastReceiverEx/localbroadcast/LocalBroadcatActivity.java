package com.mer.broadcastReceiverEx.localbroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;

import com.mer.broadcastReceiverEx.R;

public class LocalBroadcatActivity extends Activity {
    LocalBroadcastManager manager;
    MyLocalBroadcaster localBroadcaster;
    String FILTER = "com.mer.broadcasttrigger";
    IntentFilter intentFilter = new IntentFilter(FILTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = LocalBroadcastManager.getInstance(this);
        localBroadcaster = new MyLocalBroadcaster();
    }

    protected void broadcastClick(View view) {
        Intent intent = new Intent(FILTER);
        intent.putExtra("msg", "Mer");
        manager.sendBroadcast(intent);
    }

    class MyLocalBroadcaster extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", intent.getStringExtra("msg"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerReceiver(localBroadcaster, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterReceiver(localBroadcaster);
    }
}