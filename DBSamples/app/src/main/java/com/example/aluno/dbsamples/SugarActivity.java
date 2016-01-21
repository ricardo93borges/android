package com.example.aluno.dbsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Iterator;

/**
 * Created by Aluno on 21/01/2016.
 */
public class SugarActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aluno a = new Aluno("Ricardo", "email@email.com");
        a.save();
        Log.d("DATABASE", a.toString());

        a = new Aluno("Borges", "email@email.com");
        a.save();
        Log.d("DATABASE", a.toString());

        a.delete();

        long c = Aluno.count(Aluno.class);
        Log.d("DATABASE", "count: "+c);
    }
}
