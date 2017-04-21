package com.example.alejandro.demo_mockups;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Clasificacion extends AppCompatActivity {
    public static final String BOOK_DETAIL_KEY = "MRData";
    private GridView gridView;
    private Adapter_Clasificacion adapter_resultados;
    private Client_Clasificacion datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_clasificacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Pilotos"));
        tabs.addTab(tabs.newTab().setText("Equipos"));
        ArrayList<Datos_Clasificacion> resultados = new ArrayList<Datos_Clasificacion>();
        gridView = (GridView) findViewById(R.id.grid);
        adapter_resultados = new Adapter_Clasificacion(this, resultados);
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
        datos = new Client_Clasificacion();
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
                        cuarto = quinto.getJSONArray("QualifyingResults");
                        // Remove all books from the adapter_circuitos
                        final ArrayList<Datos_Clasificacion> resultado = Datos_Clasificacion.fromJson(cuarto);
                        adapter_resultados.clear();
                        // Load model objects into the adapter_circuitos

                        for (Datos_Clasificacion result : resultado) {
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
            String query = "qualifying.json";
            fetchBooks(query);

        return true;
    }

}
