package com.example.alejandro.demo_mockups;

/**
 * Created by jordi on 12/03/2017.
 */

public class Datos_Circuitos {
    private String nombre;
    private int idDrawable;

    public Datos_Circuitos(String nombre, int idDrawable) {
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

    public static Datos_Circuitos[] ITEMS = {
            new Datos_Circuitos("Jaguar F-Type 2015", R.drawable.jaguar_f_type_2015),
            new Datos_Circuitos("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt),
            new Datos_Circuitos("Mazda MX-5", R.drawable.mazda_mx5_2015),
            new Datos_Circuitos("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new Datos_Circuitos("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new Datos_Circuitos("Ford Mondeo", R.drawable.ford_mondeo),
            new Datos_Circuitos("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new Datos_Circuitos("Jaguar XE", R.drawable.jaguar_xe),
            new Datos_Circuitos("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new Datos_Circuitos("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
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
