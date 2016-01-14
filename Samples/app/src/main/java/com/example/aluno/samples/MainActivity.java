package com.example.aluno.samples;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Aluno on 13/01/2016.
 */
public class MainActivity extends Activity {
    private String[] itens = {"Item 1","Item 2","Item 3",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens));
    }

/*
    StartResultForActivity(intent, RequestCode);
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 9999:
                if(resultCode == 1) {
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
                }
                //persiste em disco
                SharedPreferences p = getSharedPreferences("MY_PREFS", 0);
                SharedPreferences.Editor e = p.edit();
                e.putString("NAME", "R");
                e.apply();
                //startActivityForResult(intent, param);
                break;
        }
    }
}
