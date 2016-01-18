package com.example.aluno.broadcastsamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Button btnRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRefresh = (Button) findViewById(R.id.btnRefresh);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        LocalBroadcastManager.getInstance(this).registerReceiver(localReceiver, new IntentFilter("LOCAL_OPEN"));
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            /*Bundle b = intent.getExtras();
            Iterator<String> it = b.keySet().iterator();
            while (it.hasNext()){
                String key = it.next();
                Log.d("Bundle", key +":"+b.get(key));
            }
            */
            boolean isConn  = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            btnRefresh.setEnabled(!isConn);
        }
    };

    public void sendB(View view){
        //sendBroadcast(new Intent(OPEN_TELA_DOIS));
        //startActivity(new Intent(this, SecondActivity.class));
        //startActivity(new Intent("EXEMPLO_ACAO_CUSTOM"));
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("LOCAL_OPEN"));
    }

    //BC local
    BroadcastReceiver localReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent it = new Intent(context, SecondActivity.class);
            it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(it);
        }
    };

    public static final String OPEN_TELA_DOIS = "ABRIR_TELA_2";

}
