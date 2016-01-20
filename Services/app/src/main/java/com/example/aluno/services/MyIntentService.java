package com.example.aluno.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Aluno on 20/01/2016.
 */
public class MyIntentService extends IntentService{

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int c = 0;
        while (c < 20) {
             Log.d("SERVICE", "onStartCommand : " + (c + 1));
            c++;
            //Broadcast to refresh
            /*Intent data = new Intent("action.SHOW_COUNT_VALUE");
            data.putExtra("COUNT.VALUE", (c+1));
            LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(data);
            */
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
    }
}
