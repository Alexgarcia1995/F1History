package com.example.alejandro.demo_mockups.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jordi on 06/04/2017.
 */

public class Datos_Resultados implements Serializable {
    private String nombre;
    private int idDrawable;
    private String nomcamp;
    private String data;
    private String corredor;
    private String corredor2;

    public Datos_Resultados() {

    }

    public String getData() {
        return data;
    }

    public String getNomcamp() {
        return nomcamp;
    }

    public Datos_Resultados(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public String getCorredor(){ return corredor; }
    public String getCorredor2(){ return corredor2; }

    public static Datos_Resultados fromJson(JSONObject jsonObject) {
        Datos_Resultados calendar = new Datos_Resultados();
        try {
            calendar.nomcamp = jsonObject.has("position") ? jsonObject.getString("position") : "";
            calendar.data = jsonObject.has("points") ? jsonObject.getString("points") : "";
           // calendar.data = jsonObject.has("number") ? jsonObject.getString("number") : "";
            calendar.corredor = jsonObject.has("Driver")? jsonObject.getJSONObject("Driver").getString("givenName"):"";
            calendar.corredor2 = jsonObject.has("Driver")? jsonObject.getJSONObject("Driver").getString("familyName"):"";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return calendar;
    }

    public static ArrayList<Datos_Resultados> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Resultados> calendars = new ArrayList<Datos_Resultados>(jsonArray.length());
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
            Datos_Resultados calendar = Datos_Resultados.fromJson(circuitoJson);
            if (calendar != null) {
                calendars.add(calendar);
            }
        }
        return calendars;
    }
}
