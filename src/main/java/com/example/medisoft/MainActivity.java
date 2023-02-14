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

    @Override
    public void onClick(View view) {
        EditText bdTransport = findViewById(R.id.bdTransport);
        EditText bdNuit =  findViewById(R.id.bdNuit);
        EditText bdRepas = findViewById(R.id.bdRepas);
        CheckBox repas2 = findViewById(R.id.repas2);
        EditText bdVisite = findViewById(R.id.bdVisite);
        RadioGroup radioGroup = findViewById(R.id.RadioGroup);
        RadioButton nbJourButton = findViewById(radioGroup.getCheckedRadioButtonId());
        int nbJour = toInt(nbJourButton.getText());

        int totalNuit = nbJour * toInt(bdNuit.getText());
        int totalRepas = nbJour * toInt(bdRepas.getText());
        if (repas2.isActivated()) {
            totalRepas += toInt(bdRepas.getText());
        }
        int totalVisite = nbJour * toInt(bdVisite.getText());

        EditText estimation = findViewById(R.id.ec);
        estimation.setText(totalNuit + totalRepas + totalVisite + toInt(bdTransport.getText()));
    }
    private int toInt(CharSequence c) {
        return Integer.getInteger(c.toString());
    }

    public void clear(View view) {
    }

    public void calcul(View view) {

    }
}