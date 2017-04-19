package com.example.alejandro.demo_mockups;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    public static final String BOOK_DETAIL_KEY = "MRData";
    private GridView gridView;
    private Adapter_Resultados adapter_resultados;
    private Client_Resultados datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Datos_Resultados> resultados = new ArrayList<Datos_Resultados>();
        gridView = (GridView) findViewById(R.id.grid);
        adapter_resultados = new Adapter_Resultados(this, resultados);
        gridView.setAdapter(adapter_resultados);
    }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    public void fetchBooks(String query) {
        // Show progress bar before making network request
        datos = new Client_Resultados();
        datos.getCalendar(query, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // hide progress bar

                    JSONObject primero = null;
                    JSONObject segundo = null;
                    JSONArray tercero = null;
                    JSONObject quinto=null;
                    JSONArray cuarto= null;
                    if (response != null) {
                        // Get the docs json array
                        primero = response.getJSONObject("MRData");
                        segundo = primero.getJSONObject("RaceTable");
                        tercero = segundo.getJSONArray("Races");
                        quinto= tercero.getJSONObject(0);
                        cuarto = quinto.getJSONArray("Results");
                        // Remove all books from the adapter_circuitos
                        final ArrayList<Datos_Resultados> resultado = Datos_Resultados.fromJson(cuarto);
                        adapter_resultados.clear();
                        // Load model objects into the adapter_circuitos

                        for (Datos_Resultados result : resultado) {
                            adapter_resultados.add(result); // add book through the adapter_circuitos
                        }

                        adapter_resultados.notifyDataSetChanged();
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
        getMenuInflater().inflate(R.menu.main, menu);
        String query = "results.json";
        fetchBooks(query);
        return true;
    }
}
