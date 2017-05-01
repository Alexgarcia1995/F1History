package com.example.alejandro.demo_mockups;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

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
    private RelativeLayout padre;
    private TextView nacimiento;
    private TextView numero;
    private TextView enlace;
    private BookClient client;
    public static ArrayList<Datos_Equipos> favs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles__equipos);
        favs=new ArrayList<>();
        nombre = (TextView) findViewById(R.id.date);
        nacionalidad = (TextView) findViewById(R.id.nacionalidad);
        enlace = (TextView) findViewById(R.id.enlace);
        padre=(RelativeLayout) findViewById(R.id.content_detalles__equipos);
        imagenExtendida=(ImageView)findViewById(R.id.imagen_equipo);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fav);
        final Datos_Equipos datos = (Datos_Equipos) getIntent().getSerializableExtra(Equipos.BOOK_DETAIL_KEY);
        loaddatos(datos);
        load_background_Equipos(datos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPreferencias();
                guardarFavs(datos);
                guardarPreferencias();
            }
        });
    }


    private void loaddatos(Datos_Equipos datos) {
        this.setTitle(datos.getTitle());
        nombre.setText(getText(R.string.Nombre_de_equipo)+" : "+datos.getname());
        nacionalidad.setText(getText(R.string.Pais_de_Origen)+" : "+datos.getnacionalidad());
        enlace.setText(Html.fromHtml("<a href="+datos.getlink()+">"+getText(R.string.Descripción_de)+" : "+datos.getname()));
        enlace.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.with(imagenExtendida.getContext()).load(Uri.parse(datos.getimagen())).into(imagenExtendida);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void load_background_Equipos(Datos_Equipos datos){

        if (datos.getnacionalidad().equals("Spanish")){
            padre.setBackgroundResource(R.drawable.hola);
        } else if (datos.getnacionalidad().equals("Italian")){
            padre.setBackgroundResource(R.drawable.italian);
        }else if (datos.getnacionalidad().equals("British")){
            padre.setBackgroundResource(R.drawable.british);
        }else if (datos.getnacionalidad().equals("Belgian")){
            padre.setBackgroundResource(R.drawable.belgian);
        }else if (datos.getnacionalidad().equals("American")){
            padre.setBackgroundResource(R.drawable.american);
        }else if (datos.getnacionalidad().equals("German")){
            padre.setBackgroundResource(R.drawable.german);
        }else if (datos.getnacionalidad().equals("Dutch")){
            padre.setBackgroundResource(R.drawable.dutch);
        }else if (datos.getnacionalidad().equals("French")){
            padre.setBackgroundResource(R.drawable.french);
        }else if (datos.getnacionalidad().equals("British")){
            padre.setBackgroundResource(R.drawable.british);
        }else if (datos.getnacionalidad().equals("New Zealander")){
            padre.setBackgroundResource(R.drawable.newzealander);
        }else if (datos.getnacionalidad().equals("Swedish")){
            padre.setBackgroundResource(R.drawable.swedish);
        }else if (datos.getnacionalidad().equals("Brazilian")){
            padre.setBackgroundResource(R.drawable.brazilian);
        }else if (datos.getnacionalidad().equals("Hungarian")){
            padre.setBackgroundResource(R.drawable.hungarian);
        }else if (datos.getnacionalidad().equals("Danish")){
            padre.setBackgroundResource(R.drawable.danish);
        }else if (datos.getnacionalidad().equals("Monegasque")){
            padre.setBackgroundResource(R.drawable.monegasque);
        }else if (datos.getnacionalidad().equals("Canadian")){
            padre.setBackgroundResource(R.drawable.canadian);
        }else if (datos.getnacionalidad().equals("Thai")){
            padre.setBackgroundResource(R.drawable.thai);
        }else if (datos.getnacionalidad().equals("South African")){
            padre.setBackgroundResource(R.drawable.southafrican);
        }else if (datos.getnacionalidad().equals("Argentine")){
            padre.setBackgroundResource(R.drawable.argentine);
        }else if (datos.getnacionalidad().equals("Finnish")){
            padre.setBackgroundResource(R.drawable.finnish);
        }else if (datos.getnacionalidad().equals("Swiss")){
            padre.setBackgroundResource(R.drawable.swiss);
        }else if (datos.getnacionalidad().equals("Irish")){
            padre.setBackgroundResource(R.drawable.irish);
        }else if (datos.getnacionalidad().equals("Uruguayan")){
            padre.setBackgroundResource(R.drawable.uruguayan);
        }else if (datos.getnacionalidad().equals("Venezuelan")){
            padre.setBackgroundResource(R.drawable.venezuelan);
        }else if (datos.getnacionalidad().equals("Indian")){
            padre.setBackgroundResource(R.drawable.indian);
        }else if (datos.getnacionalidad().equals("Portuguese")){
            padre.setBackgroundResource(R.drawable.portuguese);
        }else if (datos.getnacionalidad().equals("Argentine-Italian")){
            padre.setBackgroundResource(R.drawable.argentine);
        }else if (datos.getnacionalidad().equals("Czech")){
            padre.setBackgroundResource(R.drawable.czech);
        }else if (datos.getnacionalidad().equals("East German")){
            padre.setBackgroundResource(R.drawable.eastgerman);
        }else if (datos.getnacionalidad().equals("Japanese")){
            padre.setBackgroundResource(R.drawable.japanese);
        }else if (datos.getnacionalidad().equals("Austrian")){
            padre.setBackgroundResource(R.drawable.austrian);
        }else if (datos.getnacionalidad().equals("Australian")){
            padre.setBackgroundResource(R.drawable.australian);
        }else if (datos.getnacionalidad().equals("Mexican")){
            padre.setBackgroundResource(R.drawable.mexican);
        }else if (datos.getnacionalidad().equals("New Zealander")){
            padre.setBackgroundResource(R.drawable.newzealander);
        }else if (datos.getnacionalidad().equals("Indian")){
            padre.setBackgroundResource(R.drawable.indian);
        }else if (datos.getnacionalidad().equals("Polish")){
            padre.setBackgroundResource(R.drawable.polish);
        }else if (datos.getnacionalidad().equals("Russian")){
            padre.setBackgroundResource(R.drawable.russian);
        }else if (datos.getnacionalidad().equals("Colombian")){
            padre.setBackgroundResource(R.drawable.colombian);
        }else if (datos.getnacionalidad().equals("Chilean")){
            padre.setBackgroundResource(R.drawable.chilean);
        }else if (datos.getnacionalidad().equals("Rhodesian")){
            padre.setBackgroundResource(R.drawable.rhodesian);
        }else if (datos.getnacionalidad().equals("Liechtensteiner")){
            padre.setBackgroundResource(R.drawable.liechtensteiner);
        }else if (datos.getnacionalidad().equals("Malaysian")){
            padre.setBackgroundResource(R.drawable.malaysian);
        }

    }
    public void guardarFavs(Datos_Equipos book) {
        int contador=0;
        if(favs.isEmpty()){
            favs.add(book);
            Toast.makeText(this, "Equipo añadido", Toast.LENGTH_SHORT).show();
        }
        else{
            for (Datos_Equipos book1 : favs){
                if(book1.getTitle().equals(book.getTitle())){
                    contador=1;
                }
            }
            if (contador==1){
                Toast.makeText(this, "Este equipo ya existe en favoritos", Toast.LENGTH_SHORT).show();
            }
            else {
                favs.add(book);
                Toast.makeText(this, "Equipo añadido", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void guardarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json=gson.toJson(favs);
        editor.putString("equipos",json);
        editor.commit();
    }

    public void cargarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("equipos", null);
        Type type = new TypeToken<ArrayList<Datos_Equipos>>() {
        }.getType();
        favs= gson.fromJson(json, type);
    }
}
