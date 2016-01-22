package com.example.aluno.contentprovidersample;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Cursor c = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);

        int number =   c.getColumnIndex(CallLog.Calls.NUMBER);
        int type =     c.getColumnIndex(CallLog.Calls.TYPE);
        int date =     c.getColumnIndex(CallLog.Calls.DATE);
        int duration = c.getColumnIndex(CallLog.Calls.DURATION);

        while( c.moveToNext() ) {
            String sNum = c.getString( number );
            int iType = c.getInt(type);
            String sType = "";
            String sDate = c.getString( date );
            Date   cDate = new Date( Long.valueOf( sDate ) );
            String sDuration = c.getString( duration );

            switch( iType ) {
                case CallLog.Calls.OUTGOING_TYPE:
                    sType = "Outgoing";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    sType = "Incoming";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    sType = "Missed";
                    break;
            }

            Log.d( "CProvider",
                    "Fone: " + sNum +
                            ", Type: " + sType +
                            ", Date: " + cDate +
                            ", Duration: " + sDuration + "\n" );
        }
    }
}
