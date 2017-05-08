package com.example.alejandro.demo_mockups.Data;

import com.example.alejandro.demo_mockups.Activities.Clasificacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jordi on 06/04/2017.
 */

public class Datos_Clasificacion implements Serializable {

    private String nomcamp;
    private String numero_corredor;
    private String corredor;

    private String ganadas;


    public Datos_Clasificacion() {

    }

    public String getnumcorredor() {
        return numero_corredor;
    }
    public String getganadas() {
        return ganadas;
    }


    public String getNomcamp() {
        return nomcamp;
    }



    public String getCorredor(){ return corredor; }

    public static Datos_Clasificacion fromJson(JSONObject jsonObject) {
        Datos_Clasificacion calendar = new Datos_Clasificacion();
        try {

            switch(Clasificacion.valor){
                case 0:
                    calendar.nomcamp = jsonObject.has("position") ? jsonObject.getString("position") : "";
                    calendar.corredor = jsonObject.has("Driver")? jsonObject.getJSONObject("Driver").getString("familyName"):"";
                    calendar.numero_corredor=jsonObject.has("points")?jsonObject.getString("points"): "";
                    calendar.ganadas=jsonObject.has("wins")?jsonObject.getString("wins"): "";

                    break;
                case 1:
                    calendar.ganadas=jsonObject.has("wins")?jsonObject.getString("wins"): "";
                    calendar.nomcamp = jsonObject.has("position") ? jsonObject.getString("position") : "";
                    calendar.corredor = jsonObject.has("Constructor")? jsonObject.getJSONObject("Constructor").getString("name"):"";
                    calendar.numero_corredor=jsonObject.has("points")?jsonObject.getString("points"): "";
                    break;
            }


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
