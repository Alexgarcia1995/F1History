package com.example.alejandro.demo_mockups.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandro.demo_mockups.Data.Datos_Circuitos;
import com.example.alejandro.demo_mockups.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MapsCircuitos extends ActionBarActivity
        implements OnMapReadyCallback{

    private GoogleMap mMap;
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private TextView nombre;
    private TextView localidad;
    private TextView pais;
    private TextView url;
    private float lat;
    private float longi;
    public static ArrayList<Datos_Circuitos> favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_circuitos);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapas);
        mapFragment.getMapAsync(this);
        favs= new ArrayList<Datos_Circuitos>();
        nombre = (TextView) findViewById(R.id.circnom);
        localidad=(TextView)findViewById(R.id.local);
        pais=(TextView)findViewById(R.id.pais);
        url=(TextView)findViewById(R.id.url);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fav);
        final Datos_Circuitos circuito= (Datos_Circuitos) getIntent().getSerializableExtra(Circuitos.BOOK_DETAIL_KEY);
        loadcircuito(circuito);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPreferencias();
                guardarFavs(circuito);
                guardarPreferencias();
            }
        });
    }

    private void loadcircuito(Datos_Circuitos circuito) {
        this.setTitle(circuito.getID());
        nombre.setText(getText(R.string.Nombre)+" : "+circuito.getNomcirc());
        localidad.setText(getText(R.string.Localidad)+" : "+circuito.getLocalidad());
        pais.setText(getText(R.string.Pais)+" : "+circuito.getPais());
        url.setText(Html.fromHtml("<a href="+circuito.getLink()+">"+getText(R.string.Historia_del_Circuito)));
        url.setMovementMethod(LinkMovementMethod.getInstance());
        lat= Float.parseFloat(circuito.getLat());
        longi=Float.parseFloat(circuito.getLongi());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        switch (Ajustes.mapa){
            case "Satelite":
                mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
                break;
            case "Relieve":
                mMap.setMapType(mMap.MAP_TYPE_NORMAL);
                break;
        }
        // Add a marker in Sydney and move the camera
        LatLng SYDNEY = new LatLng(lat, longi);
        MarkerOptions marker=new MarkerOptions().position(SYDNEY)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(marker);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),15));
    }


    public void guardarFavs(Datos_Circuitos book) {
        int contador=0;
        if(favs.isEmpty()){
            favs.add(book);
            Toast.makeText(this, "Circuito añadido", Toast.LENGTH_SHORT).show();
        }
        else{
            for (Datos_Circuitos book1 : favs){
                if(book1.getID().equals(book.getID())){
                    contador=1;
                }
            }
            if (contador==1){
                Toast.makeText(this, "Este circuito ya existe en favoritos", Toast.LENGTH_SHORT).show();
            }
            else {
                favs.add(book);
                Toast.makeText(this, "Circuito añadido", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void guardarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json=gson.toJson(favs);
        editor.putString("circuitos",json);
        editor.commit();
    }

    public void cargarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("circuitos", null);
        Type type = new TypeToken<ArrayList<Datos_Circuitos>>() {
        }.getType();
        favs= gson.fromJson(json, type);
    }
}
