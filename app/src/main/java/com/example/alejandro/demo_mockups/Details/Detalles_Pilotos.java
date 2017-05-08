package com.example.alejandro.demo_mockups.Details;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandro.demo_mockups.Activities.Pilotos;
import com.example.alejandro.demo_mockups.Data.Book;
import com.example.alejandro.demo_mockups.Clients.BookClient;
import com.example.alejandro.demo_mockups.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Detalles_Pilotos extends ActionBarActivity {
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private FloatingActionButton fab;
    private ImageView imagenExtendida;
    private TextView nombre;
    private TextView nacionalidad;
    private TextView nacimiento;
    private TextView numero;
    private TextView enlace;
    private RelativeLayout padre;
    private BookClient client;
    private Book books;
    public static ArrayList<Book> favs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favs= new ArrayList<Book>();
        setContentView(R.layout.activity_detalles__pilotos);
        nombre = (TextView) findViewById(R.id.date);
        nacimiento = (TextView) findViewById(R.id.birth);
        nacionalidad = (TextView) findViewById(R.id.nacionalidad);
        numero = (TextView) findViewById(R.id.numero);
        enlace = (TextView) findViewById(R.id.enlace);
        padre=(RelativeLayout) findViewById(R.id.content_detalles__pilotos);
        fab = (FloatingActionButton) findViewById(R.id.fav);
        imagenExtendida=(ImageView)findViewById(R.id.imagen_extendida);
        books = (Book) getIntent().getSerializableExtra(Pilotos.BOOK_DETAIL_KEY);
        loadBook(books);
        load_background_Pilotos(books);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPreferencias();
                guardarFavs(books);
                guardarPreferencias();
            }
        });
    }


    private void loadBook(Book book) {
        this.setTitle(book.getalias());
        nombre.setText(getText(R.string.Nombre)+" : "+book.getname() + " " + book.getalias());
        nacionalidad.setText(getText(R.string.Nacionalidad)+" : "+book.getnacionalidad());
        nacimiento.setText(getText(R.string.Fecha_de_Nacimiento)+" : "+book.getdatebirth());
        numero.setText(getText(R.string.Numero_de_Carrera)+" : "+book.getpermanentNumber());
        enlace.setText(Html.fromHtml("<a href=" + book.getlink() + ">"+getText(R.string.Biografia_de)+" : "+book.getname() + " " + book.getalias()));
        enlace.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.with(imagenExtendida.getContext()).load(Uri.parse(book.getimagen())).into(imagenExtendida);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void load_background_Pilotos(Book book){

        if (book.getnacionalidad().equals("Spanish")){
            padre.setBackgroundResource(R.drawable.hola);
        } else if (book.getnacionalidad().equals("Italian")){
            padre.setBackgroundResource(R.drawable.italian);
        }else if (book.getnacionalidad().equals("British")){
            padre.setBackgroundResource(R.drawable.british);
        }else if (book.getnacionalidad().equals("Belgian")){
            padre.setBackgroundResource(R.drawable.belgian);
        }else if (book.getnacionalidad().equals("American")){
            padre.setBackgroundResource(R.drawable.american);
        }else if (book.getnacionalidad().equals("German")){
            padre.setBackgroundResource(R.drawable.german);
        }else if (book.getnacionalidad().equals("Dutch")){
            padre.setBackgroundResource(R.drawable.dutch);
        }else if (book.getnacionalidad().equals("French")){
            padre.setBackgroundResource(R.drawable.french);
        }else if (book.getnacionalidad().equals("British")){
            padre.setBackgroundResource(R.drawable.british);
        }else if (book.getnacionalidad().equals("New Zealander")){
            padre.setBackgroundResource(R.drawable.newzealander);
        }else if (book.getnacionalidad().equals("Swedish")){
            padre.setBackgroundResource(R.drawable.swedish);
        }else if (book.getnacionalidad().equals("Brazilian")){
            padre.setBackgroundResource(R.drawable.brazilian);
        }else if (book.getnacionalidad().equals("Hungarian")){
            padre.setBackgroundResource(R.drawable.hungarian);
        }else if (book.getnacionalidad().equals("Danish")){
            padre.setBackgroundResource(R.drawable.danish);
        }else if (book.getnacionalidad().equals("Monegasque")){
            padre.setBackgroundResource(R.drawable.monegasque);
        }else if (book.getnacionalidad().equals("Canadian")){
            padre.setBackgroundResource(R.drawable.canadian);
        }else if (book.getnacionalidad().equals("Thai")){
            padre.setBackgroundResource(R.drawable.thai);
        }else if (book.getnacionalidad().equals("South African")){
            padre.setBackgroundResource(R.drawable.southafrican);
        }else if (book.getnacionalidad().equals("Argentine")){
            padre.setBackgroundResource(R.drawable.argentine);
        }else if (book.getnacionalidad().equals("Finnish")){
            padre.setBackgroundResource(R.drawable.finnish);
        }else if (book.getnacionalidad().equals("Swiss")){
            padre.setBackgroundResource(R.drawable.swiss);
        }else if (book.getnacionalidad().equals("Irish")){
            padre.setBackgroundResource(R.drawable.irish);
        }else if (book.getnacionalidad().equals("Uruguayan")){
            padre.setBackgroundResource(R.drawable.uruguayan);
        }else if (book.getnacionalidad().equals("Venezuelan")){
            padre.setBackgroundResource(R.drawable.venezuelan);
        }else if (book.getnacionalidad().equals("Indian")){
            padre.setBackgroundResource(R.drawable.indian);
        }else if (book.getnacionalidad().equals("Portuguese")){
            padre.setBackgroundResource(R.drawable.portuguese);
        }else if (book.getnacionalidad().equals("Argentine-Italian")){
            padre.setBackgroundResource(R.drawable.argentine);
        }else if (book.getnacionalidad().equals("Czech")){
            padre.setBackgroundResource(R.drawable.czech);
        }else if (book.getnacionalidad().equals("East German")){
            padre.setBackgroundResource(R.drawable.eastgerman);
        }else if (book.getnacionalidad().equals("Japanese")){
            padre.setBackgroundResource(R.drawable.japanese);
        }else if (book.getnacionalidad().equals("Austrian")){
            padre.setBackgroundResource(R.drawable.austrian);
        }else if (book.getnacionalidad().equals("Australian")){
            padre.setBackgroundResource(R.drawable.australian);
        }else if (book.getnacionalidad().equals("Mexican")){
            padre.setBackgroundResource(R.drawable.mexican);
        }else if (book.getnacionalidad().equals("New Zealander")){
            padre.setBackgroundResource(R.drawable.newzealander);
        }else if (book.getnacionalidad().equals("Indian")){
            padre.setBackgroundResource(R.drawable.indian);
        }else if (book.getnacionalidad().equals("Polish")){
            padre.setBackgroundResource(R.drawable.polish);
        }else if (book.getnacionalidad().equals("Russian")){
            padre.setBackgroundResource(R.drawable.russian);
        }else if (book.getnacionalidad().equals("Colombian")){
            padre.setBackgroundResource(R.drawable.colombian);
        }else if (book.getnacionalidad().equals("Chilean")){
            padre.setBackgroundResource(R.drawable.chilean);
        }else if (book.getnacionalidad().equals("Rhodesian")){
            padre.setBackgroundResource(R.drawable.rhodesian);
        }else if (book.getnacionalidad().equals("Liechtensteiner")){
            padre.setBackgroundResource(R.drawable.liechtensteiner);
        }else if (book.getnacionalidad().equals("Malaysian")){
            padre.setBackgroundResource(R.drawable.malaysian);
        }

    }

    public void guardarFavs(Book book) {
        int contador=0;
        if(favs.isEmpty()){
            favs.add(book);
            Toast.makeText(this, "Piloto añadido", Toast.LENGTH_SHORT).show();
        }
        else{
            for (Book book1 : favs){
                if(book1.getalias().equals(book.getalias())){
                    contador=1;
                }
            }
            if (contador==1){
                Toast.makeText(this, "Este piloto ya existe en favoritos", Toast.LENGTH_SHORT).show();
            }
            else {
                favs.add(book);
                Toast.makeText(this, "Piloto añadido", Toast.LENGTH_SHORT).show();
            }
            }
        }


    public void guardarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json=gson.toJson(favs);
        editor.putString("pilotos",json);
        editor.commit();
    }

    public void cargarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("pilotos", null);
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        favs= gson.fromJson(json, type);
    }
}
