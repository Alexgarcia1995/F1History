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
 * Created by jordi on 12/03/2017.
 */

public class Adapter_Circuitos extends ArrayAdapter<Datos_Circuitos> {

    public Adapter_Circuitos(Context context, ArrayList<Datos_Circuitos> circuito) {
        super(context, 0, circuito);
    }
    private static class ViewHolder {
        public ImageView ivCover;
        public TextView tvTitle;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Circuitos circuit = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Circuitos.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Circuitos.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid_item, parent, false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.imagen_coche);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.nombre_coche);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(circuit.getID());

        // viewHolder.nacionalidad.setText(book.getnacionalidad());
        // Return the completed view to render on screen
        return convertView;
    }
}
