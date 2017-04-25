package com.example.alejandro.demo_mockups;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    public static ArrayList<Book> favs=new ArrayList<Book>();
    private GridView gridView;
    private Adapter_Pilotos adapter;
    public static final String BOOK_DETAIL_KEY = "MRData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        gridView=(GridView)findViewById(R.id.grid);
        adapter=new Adapter_Pilotos(this,favs);
        gridView.setAdapter(adapter);
        setupBookSelectedListener();
    }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
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
    }
}
