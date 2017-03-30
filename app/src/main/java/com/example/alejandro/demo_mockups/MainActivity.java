package com.example.alejandro.demo_mockups;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button resultados;
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ButtonSelected(){
        resultados=(Button)findViewById(R.id.resultados);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Resultados.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.clasificacionC);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Clasificacion.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.clasificacionP);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Clasificacion.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.calendario);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Calendario.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.circuitos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Circuitos.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.equipos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent resu =new Intent(MainActivity.this,Equipos.class);
                startActivity(resu);

            }
        });

        resultados=(Button)findViewById(R.id.pilotos);
        resultados.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                /////
                Intent resu =new Intent(MainActivity.this,Pilotos.class);
                startActivity(resu);

            }
        });
    }


}
