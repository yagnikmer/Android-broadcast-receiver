package com.mer.broadcastReceiverEx.orderedbroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mer.broadcastReceiverEx.R;

public class OrderedBroadcastActivity extends Activity {

    String FILTER = "com.mer.broadcasttrigger";
    String PERMISSION = "com.mer.broadcastReceiverEx.broadcast.ORDERED_BROADCAST";
    Receiver1 receiver1 = new Receiver1();
    Receiver2 receiver2 = new Receiver2();
    Receiver3 receiver3 = new Receiver3();
    Receiver4 receiver4 = new Receiver4();
    IntentFilter intentFilter = new IntentFilter(FILTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void broadcastClick(View view) {
        Intent intent = new Intent(FILTER);
        intent.putExtra("msg", "Yagnik");
        sendOrderedBroadcast(intent,PERMISSION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilter.setPriority(333);
        registerReceiver(receiver1, intentFilter);
        intentFilter.setPriority(222);
        registerReceiver(receiver2, intentFilter);
        intentFilter.setPriority(111);
        registerReceiver(receiver3, intentFilter);
        intentFilter.setPriority(444);
        registerReceiver(receiver4, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver1);
        unregisterReceiver(receiver2);
        unregisterReceiver(receiver3);
        unregisterReceiver(receiver4);
        super.onPause();
    }


    class Receiver1 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", "Receiver : 1 " + intent.getStringExtra("msg"));
        }
    }

    class Receiver2 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", "Receiver : 2 " + intent.getStringExtra("msg"));
        }
    }

    class Receiver3 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", "Receiver : 3 " + intent.getStringExtra("msg"));
        }
    }

    class Receiver4 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AppFlow", "Receiver : 4 " + intent.getStringExtra("msg"));
        }
    }
}
