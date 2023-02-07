package com.example.medisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView resultat;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    public void onClick(View view) {

    }

    public void clear(View view) {
    }

    public void calcul(View view) {

    }
}