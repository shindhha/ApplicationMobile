package com.example.medisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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



    public void clicAxeA(View view) {
    }

    @Override
    public void onClick(View view) {

    }

    public void clicTous(View view) {
    }

    public void clicTroncCommun(View view) {
    }

    public void clicAxeB(View view) {
    }
}