package com.example.aluno.handlersamples;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtA;
    EditText edtB;
    EditText edtRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = (EditText) findViewById(R.id.editTextA);
        edtB = (EditText) findViewById(R.id.editTextB);
        edtRes = (EditText) findViewById(R.id.resultado);
    }

    public void onClick(View v){
        if(v.getId() == R.id.btnSoma1){
            execSample1();
        }else if(v.getId() == R.id.btnSoma2){
            execSample2();
        }else if(v.getId() == R.id.btnSoma3){
            execSample3();
        }
    }

    //Ruim
    public void execSample1(){
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        sleep(20000);
        edtRes.setText(String.valueOf(a+b));
    }

    //Pessimo
    public void execSample2(){
        new Thread(){
            @Override
            public void run() {
                execSample1();
            }
        }.start();
    }

    //OK
    public void execSample3(){
        new Thread(){
            @Override
            public void run() {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                MainActivity.sleep(20000);

                Bundle bundle = new Bundle();
                bundle.putInt("SOMA", (a + b));

                Message m = new Message();
                m.what = 1000;
                m.setData(bundle);

                mHandle.sendMessage(m);
            }
        }.start();
    }

    Handler mHandle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1000:
                    int soma = msg.getData().getInt("SOMA");
                    edtRes.setText(String.valueOf(soma));
                    break;

            }
        }
    };

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){}
    }

}
