package com.example.alejandro.demo_mockups.Data;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by jordi on 06/04/2017.
 */
public class Datos_Equipos implements Serializable {
    private int idDrawable;
    private String nombre;
    private String title;
    private String permanentNumber;
    private String name;
    private String alias;
    private String datebirth;
    private String nacionalidad;
    private String link;
    public Datos_Equipos( int idDrawable) {
        this.idDrawable = idDrawable;
    }
    public Datos_Equipos() {

    }
    public int getIdDrawable() {
        return idDrawable;
    }

    public String getTitle() {
        return title;
    }

    public String getpermanentNumber() {
        return permanentNumber;
    }
    public String getname() {
        return name;
    }
    public String getalias() {
        return alias;
    }
    public String getdatebirth() {
        return datebirth;
    }
    public String getnacionalidad() {
        return nacionalidad;
    }
    public String getlink() {
        return link;
    }
    public String getimagen (){
        if (getTitle().equals("force_india")){
            return "http://formula1.lne.es/media/escuderias/medium/force-india.jpg";
        }else if (getTitle().equals("haas")){
            return "http://formula1.lne.es/media/escuderias/big/haas.jpg";
        }else if (getTitle().equals("red_bull")){
            return "http://formula1.lne.es/media/escuderias/medium/red-bull.jpg";
        }else if (getTitle().equals("toro_rosso")){
            return "http://formula1.lne.es/media/escuderias/medium/toro-rosso.jpg";
        }
        return "http://formula1.lne.es/media/escuderias/medium/"+getTitle()+".jpg";
    }
    // Get medium sized book cover from covers API


    // Returns a Book given the expected JSON
    public static Datos_Equipos fromJson(JSONObject jsonObject) {
        Datos_Equipos datos = new Datos_Equipos();
        try {
            datos.title = jsonObject.has("constructorId") ? jsonObject.getString("constructorId") : "";
            datos.name = jsonObject.has("name") ? jsonObject.getString("name") : "";
            datos.nacionalidad = jsonObject.has("nationality") ? jsonObject.getString("nationality") : "";
            datos.link = jsonObject.has("url") ? jsonObject.getString("url") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return datos;
    }
    // Return comma separated author list when there is more than one author
    private static String getAuthor(final JSONObject jsonObject) {
        try {
          //  final JSONArray authors = jsonObject.getJSONArray("author_name");
            final JSONArray authors = jsonObject.getJSONArray("driverId");
            int numAuthors = authors.length();
            final String[] authorStrings = new String[numAuthors];
            for (int i = 0; i < numAuthors; ++i) {
                authorStrings[i] = authors.getString(i);
            }
            return TextUtils.join(", ", authorStrings);
        } catch (JSONException e) {
            return "";
        }
    }
    // Decodes array of book json results into business model objects
    public static ArrayList<Datos_Equipos> fromJson(JSONArray jsonArray) {
        ArrayList<Datos_Equipos> datos = new ArrayList<Datos_Equipos>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject datosJson = null;
            try {
                datosJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Datos_Equipos Datos = Datos_Equipos.fromJson(datosJson);
            if (Datos != null) {
                datos.add(Datos);
            }
        }
        return datos;
    }

    public int getId() {
        return nombre.hashCode();
    }

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
}
