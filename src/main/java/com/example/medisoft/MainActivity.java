package com.example.medisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView texteResultat;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texteResultat = findViewById(R.id.texteResultat);
        datePicker = findViewById(R.id.selecteurDate);
    }


    @Override
    public void onClick(View view) {

    }

    public void clicRechercher(View view) {
        String jourSemaine = CalculDate.jourSemaine(datePicker.getDayOfMonth(),datePicker.getMonth(),datePicker.getYear());
        texteResultat.setText("Cette date correspond à un " + jourSemaine);
    }
}