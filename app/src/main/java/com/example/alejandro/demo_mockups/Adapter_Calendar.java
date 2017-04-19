package com.example.alejandro.demo_mockups;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 04/04/2017.
 */

public class Adapter_Calendar extends ArrayAdapter<Datos_Calendar> {


    public Adapter_Calendar(Context context, ArrayList<Datos_Calendar> circuito) {
        super(context, 0, circuito);
    }
    private static class ViewHolder {
        public TextView ivCover;
        public TextView tvTitle;
        public TextView hora;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Calendar circuit = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Calendar.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Calendar.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid__list, parent, false);
            viewHolder.ivCover = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.date);
            viewHolder.hora = (TextView)convertView.findViewById(R.id.hora);
            //viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            //  viewHolder.nacionalidad = (TextView)convertView.findViewById(R.id.nacionalidad);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.ivCover.setText(circuit.getNomcamp());
        viewHolder.tvTitle.setText(circuit.getData());
        viewHolder.hora.setText(circuit.getTime());
        // viewHolder.nacionalidad.setText(book.getnacionalidad());
        // Return the completed view to render on screen
        return convertView;
    }
}
