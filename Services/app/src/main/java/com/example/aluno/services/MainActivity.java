package com.example.aluno.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ServiceConnection{

    ICount myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = new Intent(this, MyService.class);
        startService(it);
       // bindService(it, this, Service.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("action.SHOW_COUNT_VALUE"));
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView label = (TextView) findViewById(R.id.tvCount);
            label.setText(""+intent.getIntExtra("COUNT.VALUE", 0));
        }
    };

    //Tratadores de clicks
    public void start(View v){
        //startService(new Intent(this, MyService.class));
        startService(new Intent(this, MyIntentService.class));
    }

    public void stop(View v){
       // unbindService(this);
        //stopService(new Intent(this, MyService.class));
        stopService(new Intent(this, MyIntentService.class));
    }

    public void refresh(View v){
        if(myService != null){
            TextView label = (TextView) findViewById(R.id.tvCount);
            label.setText(""+myService.getCount());
        }
    }

    //Connection
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyService.MyBinder mBinder = (MyService.MyBinder)service;
        myService = (ICount)mBinder.getServiceInstance();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        myService = null;
    }
}
