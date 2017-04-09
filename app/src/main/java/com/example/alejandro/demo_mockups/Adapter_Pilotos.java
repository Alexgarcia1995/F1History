package com.example.alejandro.demo_mockups;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Alejandro on 10/03/2017.
 */

public class Adapter_Pilotos extends ArrayAdapter<Book> {




    // View lookup cache
    private static class ViewHolder {
        public ImageView ivCover;
        public TextView tvTitle;

    }

    public Adapter_Pilotos(Context context, ArrayList<Book> aBooks) {
        super(context, 0, aBooks);
    }

    // Translates a particular `Book` given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_grid_item, parent, false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.imagen_coche);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.nombre_coche);
            //viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            //  viewHolder.nacionalidad = (TextView)convertView.findViewById(R.id.nacionalidad);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(book.getTitle());
        Picasso.with(getContext()).load(Uri.parse(book.getimagen())).into(viewHolder.ivCover);
        // viewHolder.nacionalidad.setText(book.getnacionalidad());
        // Return the completed view to render on screen
        return convertView;
    }

}
