package com.example.alejandro.demo_mockups;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.solver.SolverVariable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    public static ArrayList<Book> favs = new ArrayList<Book>();
    private GridView gridView;
    private Adapter_Pilotos adapter;
    public static final String BOOK_DETAIL_KEY = "MRData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarPreferencias();
        setContentView(R.layout.activity_pilotos);
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
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setLongClickable(true);
        adapter = new Adapter_Pilotos(this, favs);
        gridView.setAdapter(adapter);
        setupBookSelectedListener();
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
                favs.remove(position);
                guardarPreferencias();
                startActivity(new Intent(Favoritos.this, Favoritos.class));
                Favoritos.this.overridePendingTransition(0, 0);
                Favoritos.this.finish();
                return false;
            }
        });
    }

    public void cargarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("pilotos", null);
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        favs = gson.fromJson(json, type);
    }

    public void guardarPreferencias() {
        SharedPreferences prefs = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favs);
        editor.putString("pilotos", json);
        editor.commit();
    }
}
