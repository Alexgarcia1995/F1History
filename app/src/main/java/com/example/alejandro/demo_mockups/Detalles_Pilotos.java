package com.example.alejandro.demo_mockups;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detalles_Pilotos extends ActionBarActivity {
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Book itemDetallado;
    private ImageView imagenExtendida;
    private ImageView background;
    private TextView nombre;
    private TextView nacionalidad;
    private TextView nacimiento;
    private TextView numero;
    private TextView enlace;
    private RelativeLayout padre;
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
        padre=(RelativeLayout) findViewById(R.id.content_detalles__pilotos);
        imagenExtendida=(ImageView)findViewById(R.id.imagen_extendida);
        Book book = (Book) getIntent().getSerializableExtra(Pilotos.BOOK_DETAIL_KEY);
        loadBook(book);

    }


    private void loadBook(Book book) {
        this.setTitle(book.getalias());
        nombre.setText(book.getname() + " " + book.getalias());
        nacionalidad.setText(book.getnacionalidad());
        nacimiento.setText(book.getdatebirth());
        numero.setText(book.getpermanentNumber());
        enlace.setText(Html.fromHtml("<a href=" + book.getlink() + "> Biografia"));
        enlace.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.with(imagenExtendida.getContext()).load(Uri.parse(book.getimagen())).into(imagenExtendida);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  
}
