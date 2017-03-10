package com.example.alejandro.demo_mockups;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Detalles_Pilotos extends AppCompatActivity {
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Datos_Pilotos itemDetallado;
    private ImageView imagenExtendida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles__pilotos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemDetallado=Datos_Pilotos.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID,0));
        imagenExtendida=(ImageView)findViewById(R.id.imagen_extendida);
        cargarImagenExtendida();

    }
    private void cargarImagenExtendida() {
        Glide.with(imagenExtendida.getContext())
                .load(itemDetallado.getIdDrawable())
                .into(imagenExtendida);
    }
}
