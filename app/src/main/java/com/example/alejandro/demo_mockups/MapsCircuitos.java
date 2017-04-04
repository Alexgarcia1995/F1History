package com.example.alejandro.demo_mockups;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

public class MapsCircuitos extends ActionBarActivity
        implements OnMapReadyCallback{

    private GoogleMap mMap;
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private TextView nombre;
    private TextView localidad;
    private TextView pais;
    private TextView url;
    private BookClient client;
    private float lat;
    private float longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_circuitos);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapas);
        mapFragment.getMapAsync(this);
        nombre = (TextView) findViewById(R.id.circnom);
        localidad=(TextView)findViewById(R.id.local);
        pais=(TextView)findViewById(R.id.pais);
        url=(TextView)findViewById(R.id.url);
        Datos_Circuitos circuito= (Datos_Circuitos) getIntent().getSerializableExtra(Circuitos.BOOK_DETAIL_KEY);
        loadcircuito(circuito);
    }

    private void loadcircuito(Datos_Circuitos circuito) {
        nombre.setText(circuito.getNomcirc());
        localidad.setText(circuito.getLocalidad());
        pais.setText(circuito.getPais());
        url.setText(circuito.getLink());
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
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
        // Add a marker in Sydney and move the camera
        LatLng SYDNEY = new LatLng(lat, longi);
        MarkerOptions marker=new MarkerOptions().position(SYDNEY)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(marker);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),15));
    }

}
