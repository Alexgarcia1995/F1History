package com.example.alejandro.demo_mockups;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Anyo_campeonato extends AppCompatActivity {
    private ArrayList<Integer> pepito;
    private RadioGroup radioGroup;
    public static String anio="2017";
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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton= (RadioButton) findViewById(checkedId);
                anio= (String) radioButton.getText();
                Toast.makeText(Anyo_campeonato.this, getText(R.string.El_año_ha_cambiado_a)+" " + anio, Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getText(R.string.Año_Competición));
        toolbar.setBackgroundColor(Color.parseColor(Ajustes.color_app));
        setupActionBar();
    }


    private void setupActionBar(){

    ActionBar actionBar =getSupportActionBar();
    if (actionBar!=null){
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
}
