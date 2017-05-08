package com.example.alejandro.demo_mockups.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.demo_mockups.Data.Datos_Circuitos;
import com.example.alejandro.demo_mockups.R;
import com.squareup.picasso.Picasso;

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
        public ImageView ivCover2;
        public ImageView ivCover3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Circuitos circuit = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Circuitos.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Circuitos.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid_item, parent, false);
            viewHolder.ivCover = (ImageView) convertView.findViewById(R.id.imagen_coche);
            viewHolder.ivCover2 = (ImageView) convertView.findViewById(R.id.imagen_coche2);
            viewHolder.ivCover3 = (ImageView) convertView.findViewById(R.id.imagen_coche3);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.nombre_coche);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(circuit.getID());
if (Picasso.with(getContext()).load(Uri.parse(circuit.getImagen1()))!=null){
    Picasso.with(getContext()).load(Uri.parse(circuit.getImagen1())).into(viewHolder.ivCover);
    Picasso.with(getContext()).load(Uri.parse(circuit.getImagen())).into(viewHolder.ivCover2);
    Picasso.with(getContext()).load(Uri.parse(circuit.getImagen2())).into(viewHolder.ivCover3);
}


        return convertView;
    }
}
