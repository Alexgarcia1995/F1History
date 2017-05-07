package com.example.alejandro.demo_mockups;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    public static ArrayList<Book> Pilotos = new ArrayList<Book>();
    public static ArrayList<Datos_Circuitos> circuitos = new ArrayList<Datos_Circuitos>();
    public static ArrayList<Datos_Equipos> equipos = new ArrayList<Datos_Equipos>();
    private GridView gridView;
    private Adapter_Pilotos adapter;
    private Adapter_Circuitos circuito;
    private Adapter_Equipos equipo;
    public static final String BOOK_DETAIL_KEY = "MRData";
    public static int valor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarPilotos();
        cargarCircuitos();
        cargarEquipos();
        setContentView(R.layout.activity_favoritos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getText(R.string.Favoritos));
        toolbar.setBackgroundColor(Color.parseColor(Ajustes.color_app));
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(getText(R.string.Pilotos)));
        tabs.addTab(tabs.newTab().setText(getText(R.string.Circuitos)));
        tabs.addTab(tabs.newTab().setText(getText(R.string.Equipos)));
        tabs.setBackgroundColor(Color.parseColor(Ajustes.color_app));
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setLongClickable(true);
        adapter = new Adapter_Pilotos(Favoritos.this, Pilotos);
        gridView.setAdapter(adapter);
        setupBookSelectedListener();
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        gridView.setLongClickable(true);
                        adapter = new Adapter_Pilotos(Favoritos.this, Pilotos);
                        gridView.setAdapter(adapter);
                        setupBookSelectedListener();
                        break;
                    case 1:
                        gridView.setLongClickable(true);
                        circuito = new Adapter_Circuitos(Favoritos.this, circuitos);
                        gridView.setAdapter(circuito);
                        setupCircuitSelectedListener();
                        break;
                    case 2:
                        gridView.setLongClickable(true);
                        equipo = new Adapter_Equipos(Favoritos.this, equipos);
                        gridView.setAdapter(equipo);
                        setupTeamSelectedListener();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupActionBar() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            // actionBar.setTitle(getText(R.string.Favoritos));
        }
    }

    public void setupBookSelectedListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(Favoritos.this, Detalles_Pilotos.class);
                intent.putExtra(BOOK_DETAIL_KEY, adapter.getItem(position));
                startActivity(intent);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int i=position;
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                Pilotos.remove(i);
                                guardarPreferencias();
                                gridView.setLongClickable(true);
                                adapter = new Adapter_Pilotos(Favoritos.this, Pilotos);
                                gridView.setAdapter(adapter);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(Favoritos.this);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            }
        });


    }
    public void setupCircuitSelectedListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(Favoritos.this, MapsCircuitos.class);
                intent.putExtra(BOOK_DETAIL_KEY, circuito.getItem(position));
                startActivity(intent);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int i=position;
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                circuitos.remove(i);
                                guardarCircuitos();
                                gridView.setLongClickable(true);
                                circuito = new Adapter_Circuitos(Favoritos.this, circuitos);
                                gridView.setAdapter(circuito);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(Favoritos.this);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            }
        });


    }
    public void setupTeamSelectedListener() {
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int i=position;
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                equipos.remove(i);
                                guardarEquipos();
                                gridView.setLongClickable(true);
                                gridView.setClickable(true);
                                equipo = new Adapter_Equipos(Favoritos.this, equipos);
                                gridView.setAdapter(equipo);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(Favoritos.this);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(Favoritos.this, Detalles_Equipos.class);
                intent.putExtra(BOOK_DETAIL_KEY, equipo.getItem(position));
                valor=1;
                startActivity(intent);
            }
        });


    }
    public void cargarPilotos() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("pilotos", null);
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        Pilotos = gson.fromJson(json, type);
    }
    public void cargarCircuitos(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("circuitos", null);
        Type type = new TypeToken<ArrayList<Datos_Circuitos>>() {
        }.getType();
        circuitos= gson.fromJson(json, type);
    }
    public void cargarEquipos(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("equipos", null);
        Type type = new TypeToken<ArrayList<Datos_Equipos>>() {
        }.getType();
        equipos= gson.fromJson(json, type);
    }

    public void guardarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Pilotos);
        editor.putString("pilotos", json);
        editor.commit();
    }
    public void guardarCircuitos(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json=gson.toJson(circuitos);
        editor.putString("circuitos",json);
        editor.commit();
    }

    public void guardarEquipos(){
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json=gson.toJson(equipos);
        editor.putString("equipos",json);
        editor.commit();
    }
}
