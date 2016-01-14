package com.example.aluno.samples;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Aluno on 14/01/2016.
 */
public class Tela2Activity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        //Get params sent by previous Activity
        Bundle b = getIntent().getExtras();
        //String nome = b.getString("nome");
    }

    public void close(View v){
        setResult(1);
    }
}
