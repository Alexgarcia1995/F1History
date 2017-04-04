package com.example.alejandro.demo_mockups;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalles_Pilotos extends ActionBarActivity {
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
        setContentView(R.layout.activity_detalles__pilotos);
        nombre = (TextView) findViewById(R.id.date);
        nacimiento = (TextView) findViewById(R.id.birth);
        nacionalidad = (TextView) findViewById(R.id.nacionalidad);
        numero = (TextView) findViewById(R.id.numero);
        enlace = (TextView) findViewById(R.id.enlace);
        Book book = (Book) getIntent().getSerializableExtra(Pilotos.BOOK_DETAIL_KEY);
        loadBook(book);
    }


    private void loadBook(Book book) {
        nombre.setText(book.getname() + " " + book.getalias());
        nacionalidad.setText(book.getnacionalidad());
        nacimiento.setText(book.getdatebirth());
        numero.setText(book.getpermanentNumber());
        enlace.setText(book.getlink());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
