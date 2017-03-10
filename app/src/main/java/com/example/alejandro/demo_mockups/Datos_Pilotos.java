package com.example.alejandro.demo_mockups;

/**
 * Created by Alejandro on 10/03/2017.
 */

public class Datos_Pilotos {
    private String nombre;
    private int idDrawable;

    public Datos_Pilotos(String nombre, int idDrawable) {
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

    public static Datos_Pilotos[] ITEMS = {
            new Datos_Pilotos("Jaguar F-Type 2015", R.drawable.jaguar_f_type_2015),
            new Datos_Pilotos("Mercedes AMG-GT", R.drawable.mercedes_benz_amg_gt),
            new Datos_Pilotos("Mazda MX-5", R.drawable.mazda_mx5_2015),
            new Datos_Pilotos("Porsche 911 GTS", R.drawable.porsche_911_gts),
            new Datos_Pilotos("BMW Serie 6", R.drawable.bmw_serie6_cabrio_2015),
            new Datos_Pilotos("Ford Mondeo", R.drawable.ford_mondeo),
            new Datos_Pilotos("Volvo V60 Cross Country", R.drawable.volvo_v60_crosscountry),
            new Datos_Pilotos("Jaguar XE", R.drawable.jaguar_xe),
            new Datos_Pilotos("VW Golf R Variant", R.drawable.volkswagen_golf_r_variant_2015),
            new Datos_Pilotos("Seat León ST Cupra", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Datos_Pilotos getItem(int id) {
        for (Datos_Pilotos item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
