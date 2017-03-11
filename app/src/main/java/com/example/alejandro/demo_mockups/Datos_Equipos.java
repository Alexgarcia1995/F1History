package com.example.alejandro.demo_mockups;

/**
 * Created by rosagandia on 11/03/2017.
 */

public class Datos_Equipos {
    private String nombre;
    private int idDrawable;

    public Datos_Equipos(String nombre, int idDrawable) {
        this.nombre = nombre;
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

    public static Datos_Equipos[] ITEMS = {
            new Datos_Equipos("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt),
            new Datos_Equipos("Mazda MX-5", R.drawable.mazda_mx5_2015),
            new Datos_Equipos("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new Datos_Equipos("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new Datos_Equipos("Ford Mondeo", R.drawable.ford_mondeo),
            new Datos_Equipos("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new Datos_Equipos("Jaguar XE", R.drawable.jaguar_xe),
            new Datos_Equipos("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new Datos_Equipos("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Datos_Equipos getItem(int id) {
        for (Datos_Equipos item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
