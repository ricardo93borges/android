package com.example.aluno.helloworld2;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Aluno on 13/01/2016.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context) {
        super(context);
    }

    private void setCronoTypeFace(Context c){
        setTypeface(Typeface.createFromAsset(c.getAssets(), "fonsts/ds-digit.ttf"));
    }
}
