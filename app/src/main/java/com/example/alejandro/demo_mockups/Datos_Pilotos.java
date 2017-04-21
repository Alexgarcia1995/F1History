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



    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */

}
