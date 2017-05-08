package com.example.alejandro.demo_mockups.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alejandro on 04/04/2017.
 */

public class Datos_Data implements Serializable {
    private String nombre;
    private int idDrawable;
    private String nomcamp;
    private String data;
    private String round;
    private String time;

    public Datos_Data() {

    }
    public String getData() {
        return data;
    }

    public Datos_Data(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }


    public static Datos_Data fromJson(JSONObject jsonObject) {
        Datos_Data calendar = new Datos_Data();
        try {
            calendar.data = jsonObject.has("date") ? jsonObject.getString("date") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return calendar;
    }

    public static ArrayList<Datos_Data> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Data> calendars = new ArrayList<Datos_Data>(jsonArray.length());
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
            Datos_Data calendar = Datos_Data.fromJson(circuitoJson);
            if (calendar != null) {
                calendars.add(calendar);
            }
        }
        return calendars;
    }
}
