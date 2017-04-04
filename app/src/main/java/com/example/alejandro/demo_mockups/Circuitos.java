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

public class Circuitos extends AppCompatActivity {
    public static final String BOOK_DETAIL_KEY = "MRData";
    private GridView gridView;
    private Adapter_Circuitos adapter_circuitos;
    private Client_Circuits datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuitos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Datos_Circuitos> circuitos = new ArrayList<Datos_Circuitos>();
        gridView = (GridView) findViewById(R.id.grid);
        adapter_circuitos = new Adapter_Circuitos(this, circuitos);
        gridView.setAdapter(adapter_circuitos);
        setupCircuitSelectedListener();
    }

    private void setupActionBar() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }


    public void fetchBooks(String query) {
        // Show progress bar before making network request
        datos = new Client_Circuits();
        datos.getCircuits(query, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // hide progress bar

                    JSONObject primero = null;
                    JSONObject segundo = null;
                    JSONArray tercero = null;
                    if (response != null) {
                        // Get the docs json array
                        primero = response.getJSONObject("MRData");
                        segundo = primero.getJSONObject("CircuitTable");
                        tercero = segundo.getJSONArray("Circuits");
                        // Remove all books from the adapter_circuitos
                        final ArrayList<Datos_Circuitos> circuits = Datos_Circuitos.fromJson(tercero);
                        adapter_circuitos.clear();
                        // Load model objects into the adapter_circuitos

                        for (Datos_Circuitos circuit : circuits) {
                            adapter_circuitos.add(circuit); // add book through the adapter_circuitos
                        }

                        adapter_circuitos.notifyDataSetChanged();
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
        String query = "circuits.json";
        fetchBooks(query);
        return true;
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
    public void setupCircuitSelectedListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(Circuitos.this, MapsCircuitos.class);
                intent.putExtra(BOOK_DETAIL_KEY,adapter_circuitos.getItem(position));
                startActivity(intent);
            }
        });
    }
}

