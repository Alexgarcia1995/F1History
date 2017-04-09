package com.example.alejandro.demo_mockups;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Anyo_campeonato extends AppCompatActivity {
    private ArrayList<Integer> pepito;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyo_campeonato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        radioGroup=new RadioGroup(this);
        pepito=new ArrayList<Integer>();
        for (int i=1980;i<=2017;i++){
            pepito.add(i);
        }
        radioGroup= (RadioGroup) findViewById(R.id.radio);
        for (int i=0; i<pepito.size();i++){
            RadioButton radioButton= new RadioButton(this);
            radioButton.setText(pepito.get(i).toString());
            radioGroup.addView(radioButton);
        }
        setSupportActionBar(toolbar);
        setupActionBar();
    }


    private void setupActionBar(){

    ActionBar actionBar =getSupportActionBar();
    if (actionBar!=null){
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
}
