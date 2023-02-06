package com.example.medisoft;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultat = findViewById(R.id.result);
        String text = getString(R.string.result);

        int nbAleatoire = OutilAleatoire.tirageAleatoire(99);
        resultat.setText(text + nbAleatoire);
    }
}