package com.example.aluno.samples;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Aluno on 14/01/2016.
 */
public class CronoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final TextView crono = (TextView) inflater.inflate(R.layout.cronometro, container);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                crono.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                crono.setText("done!");
            }
        }.start();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
