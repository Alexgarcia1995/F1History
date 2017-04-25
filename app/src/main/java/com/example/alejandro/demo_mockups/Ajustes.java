package com.example.alejandro.demo_mockups;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Ajustes extends AppCompatActivity {
    public static String mapa;
    public static String idioma;
    public static String color_app;
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getText(R.string.Ajustes));
        toolbar.setBackgroundColor(Color.parseColor(color_app));
        setupActionBar();
        String [] valor1 = {"Español","Ingles"};
        String [] valor2 = {"Gris","Naranja","Violeta"};
        Button btn = (Button) findViewById(R.id.guardar);
        String[] plants;
        if (idioma.equals("en")){
            plants= new String[]{"English", "Spanish"};
        }
        else{
            plants=new String[]{
                    "Español",
                    "Ingles",
            };
        }
        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        final String sat=(String) getText(R.string.Satelite);
        final String rel=(String) getText(R.string.Relieve);
        String [] valor = {sat,rel};
        if(mapa.equals("Relieve")){
            valor =new String[]{rel,sat};
        }
        //
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,plantsList);
        //
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,valor);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,valor2);
        spinner=(Spinner) findViewById(R.id.spinner);
        spinner1=(Spinner) findViewById(R.id.spinner2);
        spinner2=(Spinner) findViewById(R.id.spinner3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
            if (spinner.getSelectedItem().toString().equals(sat)){
                    mapa = "Satelite";
                guardarPreferencias();
            }else if (spinner.getSelectedItem().toString().equals(rel)){
                     mapa = "Relieve";
                guardarPreferencias();
            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }
        });


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public Integer number;
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

    
                if (spinner1.getSelectedItem().toString() == "Español") {
                    idioma = "es";
                    guardarPreferencias();
                   // guardarPreferencias();
                } else if (spinner1.getSelectedItem().toString() == "Ingles") {
                        idioma = "en";
                    guardarPreferencias();
                } else if (spinner1.getSelectedItem().toString() == "Spanish") {
                    idioma = "es";
                    guardarPreferencias();
                    // idioma();
                   //   guardarPreferencias();
                        //  restartActivity(mActivity);
                        //   reiniciar_layout();
                    }



                }
               // idioma();





/*
            public void restartActivity(Activity Ajustes){

                Intent intent=new Intent();
                intent.setClass(Ajustes, Ajustes.getClass());
                Ajustes.startActivity(intent);
                Ajustes.finish();

            }
*/
            /*
            public  void reiniciar_layout(){
                Intent intent = new Intent(Ajustes.this, Ajustes.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
*/
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }

        });


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (spinner2.getSelectedItem().toString() == "Gris") {

                        color_app="#777777";
                        guardarPreferencias();
                        //esta opcion desactivada cambia el color del windows (parte superior toolbar)
                        /*
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.CYAN);
                        */

                    // reiniciar_layout();
                } else if (spinner2.getSelectedItem().toString() == "Naranja") {

                        color_app="#FC9403";
                        guardarPreferencias();
                    //  restartActivity(mActivity);
                    //   reiniciar_layout();
                }else if (spinner2.getSelectedItem().toString() == "Violeta"){
                        color_app="#9205C9";
                        guardarPreferencias();
                    /*
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    }
                    */
                }
              //  mapa = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
            }

/*
    boolean preferenciasGuardadas;


    public void guardarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("preferenciasMiApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preferenciasGuardadas", true);
        editor.putString("idioma", idioma);
       // editor.putString("preferencia2", "y tambien esto");
        editor.commit();
        Toast.makeText(this, "guardando preferencias", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, idioma, Toast.LENGTH_SHORT).show();
    }


    public void cargarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("preferenciasMiApp", Context.MODE_PRIVATE);
        this.idioma = prefs.getString("idioma", "es");
        Toast.makeText(this, idioma, Toast.LENGTH_SHORT).show();
      //  this.preferencias2 = prefs.getString("preferencia2", "valor por defecto");
        preferenciasGuardadas = prefs.getBoolean("preferenciasGuardadas", false);

    }
    public void idiomas(){

        Locale localizacion = new Locale(idioma);
        Locale.setDefault(localizacion);
        Configuration config = new Configuration();
        config.locale = localizacion;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }

    protected void onStart() {
        super.onStart();
        cargarPreferencias();
        idiomas();
// para ver el funcionamiento, imprimimos preferencias si existen
        String mensaje = "";
        if (this.preferenciasGuardadas) {
            mensaje = "Las preferencias fueron guardadas ya";
        } else {
            mensaje = "Las preferencias todavia no se guardaron";
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    public void onDestroy(){
        super.onDestroy();
        guardarPreferencias();
    }








*/




    public void guardarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("preferenciasMiApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preferenciasGuardadas", true);
        editor.putString("idioma", Ajustes.idioma);
        editor.putString("mapa",Ajustes.mapa);
        editor.putString("color",Ajustes.color_app);
        // editor.putString("preferencia2", "y tambien esto");
        editor.commit();
        Toast.makeText(this, "guardando preferencias", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,  Ajustes.idioma, Toast.LENGTH_SHORT).show();
    }



    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }








}
