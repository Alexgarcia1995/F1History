package com.example.alejandro.demo_mockups;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jordi on 06/04/2017.
 */

public class Adapter_Resultados extends ArrayAdapter<Datos_Resultados> {


    public Adapter_Resultados(Context context, ArrayList<Datos_Resultados> resultados) {
        super(context, 0, resultados);
    }
    private static class ViewHolder {
        public TextView posicion;
        public TextView puntos;
        public TextView corredor;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Resultados resultado = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Resultados.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Resultados.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid__list2, parent, false);
            viewHolder.posicion = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.puntos = (TextView)convertView.findViewById(R.id.date);
            viewHolder.corredor = (TextView)convertView.findViewById(R.id.corredor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.posicion.setText(resultado.getNomcamp());
        viewHolder.puntos.setText(resultado.getData());
        viewHolder.corredor.setText(resultado.getCorredor()+" "+resultado.getCorredor2());

        // viewHolder.nacionalidad.setText(book.getnacionalidad());
        // Return the completed view to render on screen
        return convertView;
    }
}
