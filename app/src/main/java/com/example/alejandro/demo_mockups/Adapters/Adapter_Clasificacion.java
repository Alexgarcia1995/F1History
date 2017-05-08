package com.example.alejandro.demo_mockups.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alejandro.demo_mockups.Data.Datos_Clasificacion;
import com.example.alejandro.demo_mockups.R;

import java.util.ArrayList;

/**
 * Created by jordi on 06/04/2017.
 */

public class Adapter_Clasificacion extends ArrayAdapter<Datos_Clasificacion> {


    public Adapter_Clasificacion(Context context, ArrayList<Datos_Clasificacion> resultados) {
        super(context, 0, resultados);
    }
    private static class ViewHolder {
        public TextView posicion;
        public TextView numero_corredor;
        public TextView corredor;
        public TextView ganadas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Datos_Clasificacion resultado = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Adapter_Clasificacion.ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new Adapter_Clasificacion.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid__list3, parent, false);
            viewHolder.posicion = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.numero_corredor = (TextView)convertView.findViewById(R.id.date);
            viewHolder.corredor = (TextView)convertView.findViewById(R.id.corredor);
            viewHolder.ganadas = (TextView)convertView.findViewById(R.id.ganadas);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.posicion.setText(resultado.getNomcamp());
        viewHolder.numero_corredor.setText(resultado.getnumcorredor());
        viewHolder.corredor.setText(resultado.getCorredor());
        viewHolder.ganadas.setText(resultado.getganadas());
        return convertView;
    }
}
