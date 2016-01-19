package com.example.aluno.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View v){
        //Configurar acao
        Intent alarmAction = new Intent("WAKEUP");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, alarmAction, 0);
        Toast.makeText(this, "SET", Toast.LENGTH_SHORT);
        //definir quando pretende que o alarme acione a acao
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 10);
        //Configurar o Alarm Manager
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), p);
    }

    public void setRepeat(View v){
        //Configurar acao
        Intent alarmAction = new Intent("WAKEUP");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, alarmAction, 0);
        Toast.makeText(this, "SET", Toast.LENGTH_SHORT);
        //definir quando pretende que o alarme acione a acao
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 10);
        //Configurar o Alarm Manager
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 4000, p);
    }

    public void cancelAlarm(View v){
        //Configurar acao
        Intent alarmAction = new Intent("WAKEUP");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, alarmAction, 0);
        Toast.makeText(this, "SET", Toast.LENGTH_SHORT);

        //Configurar o Alarm Manager
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(p);
    }
}
