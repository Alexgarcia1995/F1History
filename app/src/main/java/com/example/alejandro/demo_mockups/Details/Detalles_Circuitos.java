package com.example.alejandro.demo_mockups.Details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.alejandro.demo_mockups.Data.Datos_Circuitos;
import com.example.alejandro.demo_mockups.R;

public class Detalles_Circuitos extends AppCompatActivity{
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Datos_Circuitos itemDetallado;
    private ImageView imagenExtendida;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles__circuitos);

    }

}

