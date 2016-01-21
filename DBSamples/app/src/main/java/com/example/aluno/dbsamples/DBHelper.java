package com.example.aluno.dbsamples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Aluno on 21/01/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 3;
    private String[] create_scripts = new String[]{
            "CREATE TABLE [alunos] (\n" +
                    "  [id] INTEGER PRIMARY KEY, \n" +
                    "  [Nome] TEXT);\n",
            "INSERT INTO alunos (nome) VALUES ('Ricardo')",
            "INSERT INTO alunos (nome) VALUES ('Borges')",
    };

    private String[] update_scripts = new String[]{
            "INSERT INTO alunos (nome) VALUES ('Ricardo')",
            "INSERT INTO alunos (nome) VALUES ('Borges')",
    };

    public DBHelper(Context context, String name) {
        super(context, name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DATABASE", "onCreate");
        for(int i = 0; i < create_scripts.length; i++){
            db.execSQL(create_scripts[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DATABASE", "onUpgrade");

        switch (oldVersion){
            case 1:
                for(int i = 0; i < 2; i++){
                    db.execSQL(update_scripts[i]);
                }
            case 2:
                for(int i = 2; i < update_scripts.length; i++){
                    db.execSQL(update_scripts[i]);
                }
        }
    }
}
