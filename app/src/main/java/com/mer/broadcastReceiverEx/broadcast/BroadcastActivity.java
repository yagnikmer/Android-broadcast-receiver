package com.mer.broadcastReceiverEx.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mer.broadcastReceiverEx.R;

public class BroadcastActivity extends Activity {

    String FILTER = "com.mer.broadcasttrigger";
    MyBroadcastReceiver receiver = new MyBroadcastReceiver();
    IntentFilter intentFilter = new IntentFilter(FILTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void broadcastClick(View view) {
        Intent intent = new Intent(FILTER);
        intent.putExtra("msg", "Yagnik Mer");
        sendBroadcast(intent);
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", intent.getStringExtra("msg"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();

    }
}
