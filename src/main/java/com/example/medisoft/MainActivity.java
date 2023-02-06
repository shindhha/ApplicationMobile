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

        resultat = findViewById(R.id.result);
        text = getString(R.string.result);


    }


    public void generNbAleatoire(View view) {

    }

    @Override
    public void onClick(View view) {

    }

    public void pileFace(View view) {
        String nbAleatoire = OutilAleatoire.tiragePileFace();
        resultat.setText(text + nbAleatoire);
    }

    public void LancerDe(View view) {
        int nbAleatoire = OutilAleatoire.tirageAleatoire(6);
        resultat.setText(text + (nbAleatoire+1));
    }

    public void Loto(View view) {
        int nbAleatoire = OutilAleatoire.tirageAleatoire(49);
        resultat.setText(text + (nbAleatoire+1) );
    }
}