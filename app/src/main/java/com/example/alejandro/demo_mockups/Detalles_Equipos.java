package com.example.alejandro.demo_mockups;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by jordi on 12/03/2017.
 */
public class Detalles_Equipos extends ActionBarActivity {
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Book itemDetallado;
    private ImageView imagenExtendida;
    private TextView nombre;
    private TextView nacionalidad;
    private TextView nacimiento;
    private TextView numero;
    private TextView enlace;
    private BookClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles__equipos);
        nombre = (TextView) findViewById(R.id.date);
        //nacimiento = (TextView) findViewById(R.id.birth);
        nacionalidad = (TextView) findViewById(R.id.nacionalidad);
        //numero = (TextView) findViewById(R.id.numero);
        enlace = (TextView) findViewById(R.id.enlace);
        Datos_Equipos datos = (Datos_Equipos) getIntent().getSerializableExtra(Equipos.BOOK_DETAIL_KEY);
        loaddatos(datos);
    }


    private void loaddatos(Datos_Equipos datos) {
        nombre.setText(datos.getname());
        nacionalidad.setText(datos.getnacionalidad());
        enlace.setText(Html.fromHtml("<a href="+datos.getlink()+"> Descripción"));
        enlace.setMovementMethod(LinkMovementMethod.getInstance());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
