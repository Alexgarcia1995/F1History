package com.example.alejandro.demo_mockups;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jordi on 06/04/2017.
 */

public class Datos_Clasificacion implements Serializable {
    private String nombre;
    private int idDrawable;
    private String nomcamp;
    private String numero_corredor;
    private String corredor;
    private String corredor2;
    private String  Q1;
    private String  Q2;
    private String  Q3;

    public Datos_Clasificacion() {

    }

    public String getnumcorredor() {
        return numero_corredor;
    }
    public String getQ1() {
        return Q1;
    }
    public String getQ2() {
        return Q2;
    }
    public String getQ3() {
        return Q3;
    }

    public String getNomcamp() {
        return nomcamp;
    }

    public Datos_Clasificacion(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public String getCorredor(){ return corredor; }
    public String getCorredor2(){ return corredor2; }

    public static Datos_Clasificacion fromJson(JSONObject jsonObject) {
        Datos_Clasificacion calendar = new Datos_Clasificacion();
        try {
            calendar.nomcamp = jsonObject.has("position") ? jsonObject.getString("position") : "";
             calendar.Q1 = jsonObject.has("Q1") ? jsonObject.getString("Q1") : "";
            calendar.Q2 = jsonObject.has("Q2") ? jsonObject.getString("Q2") : "";
            calendar.Q3 = jsonObject.has("Q3") ? jsonObject.getString("Q3") : "";
            calendar.numero_corredor = jsonObject.has("number") ? jsonObject.getString("number") : "";
            calendar.corredor = jsonObject.has("Driver")? jsonObject.getJSONObject("Driver").getString("familyName"):"";
            calendar.corredor2 = jsonObject.has("Driver")? jsonObject.getJSONObject("Driver").getString("givenName"):"";

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return calendar;
    }

    public static ArrayList<Datos_Clasificacion> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Clasificacion> calendars = new ArrayList<Datos_Clasificacion>(jsonArray.length());
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
            Datos_Clasificacion calendar = Datos_Clasificacion.fromJson(circuitoJson);
            if (calendar != null) {
                calendars.add(calendar);
            }
        }
        return calendars;
    }
}
