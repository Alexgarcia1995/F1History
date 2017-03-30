package com.example.alejandro.demo_mockups;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pilotos extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    public static final String BOOK_DETAIL_KEY = "MRData";
    private BookClient client;
    private GridView gridView;
    private Adapter_Pilotos adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilotos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Book> aBooks = new ArrayList<Book>();
        gridView=(GridView)findViewById(R.id.grid);
        adapter=new Adapter_Pilotos(this,aBooks);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

    }

    public void fetchBooks(String query) {
        // Show progress bar before making network request
        client = new BookClient();
        client.getBooks(query, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // hide progress bar

                    JSONObject primero=null;
                    JSONObject segundo=null;
                    JSONArray tercero = null;
                    if(response != null) {
                        // Get the docs json array
                        primero=response.getJSONObject("MRData");
                        segundo=primero.getJSONObject("DriverTable");
                        tercero=segundo.getJSONArray("Drivers");
                        // Remove all books from the adapter
                        final ArrayList<Book> books = Book.fromJson(tercero);
                        adapter.clear();
                        // Load model objects into the adapter

                        for (Book book : books) {
                            adapter.add(book); // add book through the adapter
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
        String query="drivers.json";
        fetchBooks(query);
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
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Datos_Pilotos item = (Datos_Pilotos)parent.getItemAtPosition(position);

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

    }
