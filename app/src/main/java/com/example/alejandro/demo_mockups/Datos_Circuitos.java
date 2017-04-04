package com.example.alejandro.demo_mockups;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by jordi on 12/03/2017.
 */

public class Datos_Circuitos implements Serializable {
    private String nombre;
    private int idDrawable;
    private String nomcirc;
    private String id;
    private String lat;
    private String longi;
    private String localidad;
    private String pais;
    private String link;
    private JSONObject location;

    public Datos_Circuitos() {

    }

    public Datos_Circuitos(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public String getNomcirc() {
        return nomcirc;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getPais() {
        return pais;
    }

    public String getLink() {
        return link;
    }

    public String getID() {
        return id;
    }

    public JSONObject getLocation(){
        return location;
    };

    public static Datos_Circuitos fromJson(JSONObject jsonObject) {
        Datos_Circuitos circuit = new Datos_Circuitos();
        try {
            circuit.id = jsonObject.has("circuitId") ? jsonObject.getString("circuitId") : "";
            circuit.nomcirc = jsonObject.has("circuitName") ? jsonObject.getString("circuitName") : "";
            circuit.link = jsonObject.has("url") ? jsonObject.getString("url") : "";
            circuit.lat=jsonObject.getJSONObject("Location").has("lat")? jsonObject.getJSONObject("Location").getString("lat"):"";
            circuit.longi=jsonObject.getJSONObject("Location").has("long")? jsonObject.getJSONObject("Location").getString("long"):"";
            circuit.localidad=jsonObject.getJSONObject("Location").has("locality")? jsonObject.getJSONObject("Location").getString("locality"):"";
            circuit.pais=jsonObject.getJSONObject("Location").has("country")? jsonObject.getJSONObject("Location").getString("country"):"";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return circuit;
    }

    public static ArrayList<Datos_Circuitos> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Circuitos> circuitos = new ArrayList<Datos_Circuitos>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject circuitoJson = null;
            try {
                circuitoJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Datos_Circuitos circuito = Datos_Circuitos.fromJson(circuitoJson);
            if (circuito != null) {
                circuitos.add(circuito);
            }
        }
        return circuitos;
    }

    public static Datos_Circuitos[] ITEMS = {
            new Datos_Circuitos(R.drawable.jaguar_f_type_2015),
            new Datos_Circuitos(R.drawable.mercedes_benz_amg_gt),
            new Datos_Circuitos(R.drawable.mazda_mx5_2015),
            new Datos_Circuitos(R.drawable.porsche_911_gts),
            new Datos_Circuitos(R.drawable.bmw_serie6_cabrio_2015),
            new Datos_Circuitos(R.drawable.ford_mondeo),
            new Datos_Circuitos(R.drawable.volvo_v60_crosscountry),
            new Datos_Circuitos(R.drawable.jaguar_xe),
            new Datos_Circuitos(R.drawable.volkswagen_golf_r_variant_2015),
            new Datos_Circuitos(R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Datos_Circuitos getItem(int id) {
        for (Datos_Circuitos item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}

