package com.example.alejandro.demo_mockups;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alejandro on 04/04/2017.
 */

public class Datos_Calendar implements Serializable {
    private String nombre;
    private int idDrawable;
    private String nomcamp;
    private String data;

    public Datos_Calendar() {

    }

    public String getData() {
        return data;
    }

    public String getNomcamp() {
        return nomcamp;
    }

    public Datos_Calendar(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }


    public static Datos_Calendar fromJson(JSONObject jsonObject) {
        Datos_Calendar calendar = new Datos_Calendar();
        try {
            calendar.nomcamp = jsonObject.has("raceName") ? jsonObject.getString("raceName") : "";
            calendar.data = jsonObject.has("date") ? jsonObject.getString("date") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return calendar;
    }

    public static ArrayList<Datos_Calendar> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Calendar> calendars = new ArrayList<Datos_Calendar>(jsonArray.length());
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
            Datos_Calendar calendar = Datos_Calendar.fromJson(circuitoJson);
            if (calendar != null) {
                calendars.add(calendar);
            }
        }
        return calendars;
    }
}
