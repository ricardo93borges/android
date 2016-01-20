package com.example.aluno.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;

public class MyService extends Service implements ICount{
    public class MyBinder extends Binder {
        public MyService getServiceInstance(){
            return MyService.this;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVICE", "onCreate");
    }

    @Override
    public void onDestroy() {
        stop = true;
        super.onDestroy();
        Log.d("SERVICE", "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        if(!running) {
            new Thread() {
                @Override
                public void run() {

                    while (c < 20 && !stop) {
                        Log.d("SERVICE", "onStartCommand : [" + startId + "]" + (c + 1));
                        c++;
                        //Broadcast to refresh
                        Intent data = new Intent("action.SHOW_COUNT_VALUE");
                        data.putExtra("COUNT.VALUE", (c+1));
                        LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(data);

                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                        }
                    }
                    running = false;
                    stopSelf();
                }
            }.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private boolean running = false;
    private boolean stop = false;
    private int c;

    public int getCount(){
        return c;
    }

}
