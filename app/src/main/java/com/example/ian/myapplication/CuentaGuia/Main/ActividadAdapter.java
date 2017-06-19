package com.example.ian.myapplication.CuentaGuia.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Ian on 18-06-2017.
 */
public class ActividadAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;


    int[] fotos = {
            R.drawable.paisaje1,
            R.drawable.paisaje2
    };


    ArrayList<Tour> tours;

    public ActividadAdapter(Context context, ArrayList<Tour> tours) {
        this.context = context;
        this.tours=tours;
    }


    @Override
    public int getCount() {
        return tours.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.style_tours_realizados, parent, false);

        TextView titulo = (TextView)itemView.findViewById(R.id.textComuna);
        TextView ciudad = (TextView)itemView.findViewById(R.id.textPrevision);

        titulo.setText(tours.get(position).getTitulo());
        ciudad.setText(tours.get(position).getCiudad());


        return itemView;
    }
}
