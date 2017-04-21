package com.example.alejandro.demo_mockups;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton resultados;
    private TextView dia, horas, minutos, segundos, evento,evento_nombre;
    private String proximo_evento;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;
    private Client_Data datos;
    private  String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // Toast.makeText(MainActivity.this, "El año ha cambiado a " +, Toast.LENGTH_SHORT).show();
        initUI();
        countDownStart();

       ButtonSelected();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        fetchBooks(".json");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    public void fetchBooks(String query) {
        // Show progress bar before making network request
        datos = new Client_Data();
        datos.getData(query, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // hide progress bar

                    JSONObject primero = null;
                    JSONObject segundo = null;
                    JSONObject datos = null;
                    JSONArray tercero = null;
                    if (response != null) {
                        // Get the docs json array
                        primero = response.getJSONObject("MRData");
                        segundo = primero.getJSONObject("RaceTable");
                        tercero = segundo.getJSONArray("Races");
                        datos=tercero.getJSONObject(0);
                        data=datos.has("date") ? datos.getString("date"):" ";
                        proximo_evento=datos.has("raceName") ? datos.getString("raceName"):" ";
                        // Remove all books from the adapter_circuitos
                        evento_nombre.setText("Proximo evento"+ Html.fromHtml("<br />") + proximo_evento);
                        // Load model objects into the adapter_circuitos


                    }
                } catch (JSONException e) {
                    // Invalid JSON format, show appropriate error.
                    e.printStackTrace();
                }
            }

            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }
        });
    }
    public void ButtonSelected(){
        resultados= (ImageButton) findViewById(R.id.resultados);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Resultados.class);
                startActivity(resu);

            }
        });

        resultados=(ImageButton)findViewById(R.id.clasificacion);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Clasificacion.class);
                startActivity(resu);

            }
        });


        resultados=(ImageButton)findViewById(R.id.calendario);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Calendario.class);
                startActivity(resu);

            }
        });

        resultados=(ImageButton)findViewById(R.id.circuitos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Circuitos.class);
                startActivity(resu);

            }
        });

        resultados=(ImageButton)findViewById(R.id.equipos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Equipos.class);
                startActivity(resu);

            }
        });

        resultados=(ImageButton)findViewById(R.id.pilotos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Pilotos.class);
                startActivity(resu);

            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent campeonato=new Intent(MainActivity.this,Anyo_campeonato.class);
            startActivity(campeonato);
        } else if (id == R.id.nav_gallery) {
            Intent Ajustes=new Intent(MainActivity.this,Ajustes.class);
            startActivity(Ajustes);
        } else if (id == R.id.nav_slideshow) {
            Intent Contact=new Intent(MainActivity.this,Contact.class);
            startActivity(Contact);
        } else if (id == R.id.nav_manage) {
            Intent About=new Intent(MainActivity.this,About.class);
            startActivity(About);
        } else if (id == R.id.nav_share) {
            Intent Login=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(Login);
        } else if (id == R.id.nav_send) {
            Intent Login=new Intent(MainActivity.this,Favoritos.class);
            startActivity(Login);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @SuppressLint("SimpleDateFormat")
    private void initUI() {
        linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        dia = (TextView) findViewById(R.id.txtTimerDay);
        horas = (TextView) findViewById(R.id.txtTimerHour);
        minutos = (TextView) findViewById(R.id.txtTimerMinute);
        segundos = (TextView) findViewById(R.id.txtTimerSecond);
        evento = (TextView) findViewById(R.id.tvevent);
        evento_nombre = (TextView) findViewById(R.id.nombre);
    }

    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Here Set your Event Date
                    Date eventDate = dateFormat.parse(data);
                    Date currentDate = new Date();
                    if (!currentDate.after(eventDate)) {
                        long diff = eventDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        dia.setText("" + String.format("%02d", days));
                        horas.setText("" + String.format("%02d", hours));
                        minutos.setText("" + String.format("%02d", minutes));
                        segundos.setText("" + String.format("%02d", seconds));
                    } else {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        evento.setText("Hoy es dia de Carrera!! ;D");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }


}
