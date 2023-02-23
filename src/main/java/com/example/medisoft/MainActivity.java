package com.example.medisoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private ListView listView;
    private String[] troncCommun;
    private String[] parcourA;
    private String[] parcourB;
    private List<String> all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.liste);

        troncCommun = getResources().getStringArray(R.array.tronc_commun);

        parcourA =getResources().getStringArray(R.array.parcours_A);

        parcourB = getResources().getStringArray(R.array.parcours_B);

        all = new ArrayList<>();
        all.addAll(Arrays.asList(troncCommun));
        all.addAll(Arrays.asList(parcourA));
        all.addAll(Arrays.asList(parcourB));
    }



    public void clicAxeA(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,parcourA);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
    }

    public void clicTous(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,all);
        listView.setAdapter(adapter);
    }

    public void clicTroncCommun(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,troncCommun);
        listView.setAdapter(adapter);
    }

    public void clicAxeB(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,parcourB);
        listView.setAdapter(adapter);
    }
}