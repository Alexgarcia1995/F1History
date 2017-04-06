package com.example.alejandro.demo_mockups;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * Created by jordi on 12/03/2017.
 */
public class Equipos extends AppCompatActivity {
    public static final String BOOK_DETAIL_KEY = "MRData";
    private Client_Equipos client;
    private GridView gridView;
    private Adapter_Equipos adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Datos_Equipos> datos = new ArrayList<Datos_Equipos>();
        gridView=(GridView)findViewById(R.id.grid);
        adapter=new Adapter_Equipos(this,datos);
        gridView.setAdapter(adapter);
        setupBookSelectedListener();
    }

    public void fetchequips(String query) {
        // Show progress bar before making network request
        client = new Client_Equipos();
        client.getequips(query, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // hide progress bar

                    JSONObject primero=null;
                    JSONObject segundo=null;
                    JSONArray tercero = null;
                    if(response != null) {
                        // Get the docs json array
                        primero=response.getJSONObject("MRData");
                        segundo=primero.getJSONObject("ConstructorTable");
                        tercero=segundo.getJSONArray("Constructors");
                        // Remove all books from the adapter
                        final ArrayList<Datos_Equipos> Datos = Datos_Equipos.fromJson(tercero);
                        adapter.clear();
                        // Load model objects into the adapter

                        for (Datos_Equipos Datoss : Datos) {
                            adapter.add(Datoss); // add book through the adapter
                        }

                        adapter.notifyDataSetChanged();
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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // final MenuItem searchItem = menu.findItem(R.id.action_search);
        //final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //earchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        String query="constructors.json";
        fetchequips(query);
/*
            public boolean onQueryTextSubmit(String query) {

               // query=(query+".json");
                // Fetch the data remotely
                // Reset SearchView
                /*
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                // Set activity title to search query
                BookListActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        */
        return true;
    }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }
   /* public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Book item = (Book)parent.getItemAtPosition(position);
        Intent intent = new Intent(this, Detalles_Pilotos.class);
        intent.putExtra(Detalles_Pilotos.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            new Pair<View, String>(view.findViewById(R.id.imagen_coche),
                                    Detalles_Pilotos.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }
*/
    public void setupBookSelectedListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(Equipos.this, Detalles_Equipos.class);
                intent.putExtra(BOOK_DETAIL_KEY, adapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    }
