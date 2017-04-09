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
        public TextView ivCover;
        public TextView tvTitle;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Resultados resultado = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Resultados.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Resultados.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid__list, parent, false);
            viewHolder.ivCover = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.ivCover.setText(resultado.getNomcamp());
        viewHolder.tvTitle.setText(resultado.getData());

        // viewHolder.nacionalidad.setText(book.getnacionalidad());
        // Return the completed view to render on screen
        return convertView;
    }
}
