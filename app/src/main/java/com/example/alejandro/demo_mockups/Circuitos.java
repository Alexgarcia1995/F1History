package com.example.alejandro.demo_mockups;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Circuitos extends AppCompatActivity
    implements AdapterView.OnItemClickListener{
        private GridView gridView;
        private Adapter_Circuitos adapter;
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
            gridView=(GridView)findViewById(R.id.grid);
            adapter=new Adapter_Circuitos(this);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(this);
        }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Datos_Circuitos item = (Datos_Circuitos)parent.getItemAtPosition(position);

        Intent intent = new Intent(this, Detalles_Circuitos.class);
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
