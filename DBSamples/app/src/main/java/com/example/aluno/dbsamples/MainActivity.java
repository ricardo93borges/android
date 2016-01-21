package com.example.aluno.dbsamples;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this, "mydatabase");
        SQLiteDatabase db = helper.getWritableDatabase();
                //SQLiteDatabase db = openOrCreateDatabase("android", MODE_PRIVATE, null);

       // dump(db);

        //insert
        ContentValues row = new ContentValues();
        row.put("nome", "teste " + System.currentTimeMillis());
        long rowId = db.insert("alunos", null, row);
        Log.d("DATABASE", "rowId : "+rowId);

        //update
        row = new ContentValues();
        row.put("nome", "teste" + (System.currentTimeMillis() + 1000));
        db.update("alunos", row, "id = ?", new String[]{String.valueOf(rowId)});

        //delete
        int numLines = db.delete("alunos", "id = "+rowId, null);
        Log.d("DATABASE", "numLines : "+numLines);

        db.close();
    }


    private void dump(SQLiteDatabase db){
        Cursor c = db.query("alunos", new String[]{"id", "nome"}, null,null,null,null,null);
        db.rawQuery("SELEC * FROM ALUNS WHERE 1=1", null);
        while (c.moveToNext()){
            Log.d("DATABASE", c.getString(c.getColumnIndex("id")) + c.getString(c.getColumnIndex("nome")));
        }

        c.close();
    }

}
