package com.example.alejandro.demo_mockups;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
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
    private String id1;
    private String urlpower;
    private String magia;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getImagen() {
        switch (getID()){
            case "indianapolis":
                id1="indy";
                break;
            case "bremgarten":
                id1="bremgarten";
                break;
            case "monza":
                id1="monza";
                break;
            case "reims":
                id1="reims";
                break;
            case "silverstone":
                id1="silver10";
                break;
            case "spa":
                id1="spa07";
                break;
            case "monaco":
                id1="monaco0308";
                break;
            case "adelaide":
                id1="adelaide";
                break;
            case "ain-diab":
                id1="aindiab";
                break;
            case "aintree":
                id1="aintree";
                break;
            case "albert_park":
                id1="melbourne";
                break;
            case "americas":
                id1="austin";
                break;
            case "anderstorp":
                id1="anderstorp";
                break;
            case "avus":
                id1="avus";
                break;
            case "bahrain":
                id1="bahrain";
                break;
            case "boavista":
                id1="oporto";
                break;
            case "brands_hatch":
                id1="brands";
                break;
            case "buddh":
                id1="buddh";
                break;
            case "catalunya":
                id1="catalunya";
                break;
            case "charade":
                id1="charade";
                break;
            case "dallas":
                id1="dallas";
                break;
            case "detroit":
                id1="detroit";
                break;
            case "dijon":
                id1="dijon";
                break;
            case "donington":
                id1="donington";
                break;
            case "essarts":
                id1="rouen57";
                break;
            case "estoril":
                id1="estoril";
                break;
            case "fuji":
                id1="fuji";
                break;
            case "galvez":
                id1="buenos_06";
                break;
            case "hockenheimring":
                id1="hockenheim";
                break;
            case "hungaroring":
                id1="hungaroring";
                break;
            case "imola":
                id1="imola";
                break;
            case "interlagos":
                id1="interlagos";
                break;
            case "istanbul":
                id1="istanbul";
                break;
            case "sepang":
                id1="sepang";
                break;
            case "suzuka":
                id1="suzuka03";
                break;
            case "villeneuve":
                id1="montreal02";
                break;
            case "BAK":
                id1="magny";
                break;
            case "valencia":
                id1="valencia";
                break;
            case "yeongam":
                id1="aida";
                break;
            case "nurburgring":
                id1="nurburgring";
                break;
            case "okayama":
                id1="aida";
                break;
            case "jerez":
                id1="jerez";
                break;
            case "phoenix":
                id1="jerez";
                break;
            case "kyalami":
                id1="kyalami";
                break;
            case "zandvoort":
                id1="eastlondon";
                break;

            case "jarama":
                id1="jarama";
                break;
            case "tremblant":
                id1="jovite";
                break;

        }
        if (getID().equals("phoenix")) {
                urlpower = "http://www.allf1.info/tracks/phoenix.gif";
        }else {
            urlpower = "http://www.allf1.info/tracks/" + id1 + ".jpg";
        }
        return urlpower;
    }

    public String getImagen1(){
        switch (getLocalidad()) {
            case "Spielburg":
                id1 = "rbring";
                break;
            case "bremgarten":
                id1 = "bremgarten";
                break;
            case "monza":
                id1 = "monza";
                break;
            case "reims":
                id1 = "reims";
                break;
            case "silverstone":
                id1 = "silver10";
                break;
            case "spa":
                id1 = "spa07";
                break;
            case "monaco":
                id1 = "monaco0308";
                break;
            case "adelaide":
                id1 = "adelaide";
                break;
            case "California":
                id1="longbeach";
                break;

        }
      //  String magia ="http://www.allf1.info/tracks/"+getLocalidad().toLowerCase()+".jpg";
        magia ="http://www.allf1.info/tracks/"+id1+".jpg";
      return magia;
    }
    public String getImagen2(){
        switch (getPais()) {
            case "Singapore":
                id1 = "singapore13";
                break;
            case "UAE":
                id1 = "abudhabi";
                break;
            case "Mexico":
                id1="mexico86";
                break;
            case "Russia":
                id1="sochi";
                break;
            case "China":
                id1="shanghai";
                break;
            case "France":
                id1="magny";
                break;
            case "Brazil":
                id1="interlagos";
                break;
        }
if (getPais()=="Spain"){
    magia ="https://www.formulaf1.es/wp-content/uploads/2012/04/circuit2.jpg";
}else {
    magia = "http://www.allf1.info/tracks/" + id1 + ".jpg";
}

        return magia;
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

