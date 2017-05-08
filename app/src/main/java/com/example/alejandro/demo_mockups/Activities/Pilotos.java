package com.example.alejandro.demo_mockups.Activities;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.alejandro.demo_mockups.Adapters.Adapter_Pilotos;
import com.example.alejandro.demo_mockups.Data.Book;
import com.example.alejandro.demo_mockups.Clients.BookClient;
import com.example.alejandro.demo_mockups.Details.Detalles_Pilotos;
import com.example.alejandro.demo_mockups.R;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pilotos extends AppCompatActivity {
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
        toolbar.setBackgroundColor(Color.parseColor(Ajustes.color_app));
        getSupportActionBar().setTitle(getText(R.string.Pilotos));
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
        setupBookSelectedListener();
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
        String query="drivers.json";
        fetchBooks(query);

        return true;
    }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    public void setupBookSelectedListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(Pilotos.this, Detalles_Pilotos.class);
                intent.putExtra(BOOK_DETAIL_KEY, adapter.getItem(position));
                startActivity(intent);
            }
        });
    }
    }
