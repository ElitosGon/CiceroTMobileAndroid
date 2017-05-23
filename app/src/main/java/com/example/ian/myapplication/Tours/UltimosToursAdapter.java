package com.example.ian.myapplication.Tours;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */
public class UltimosToursAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;


    int[] fotos = {
            R.drawable.paisaje1,
            R.drawable.paisaje2
    };


    ArrayList<Tour> tours;

    public UltimosToursAdapter(Context context, ArrayList<Tour> tours) {
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

        View itemView = inflater.inflate(R.layout.style_groupon, parent, false);

        TextView titulo = (TextView)itemView.findViewById(R.id.titulo);
        TextView region = (TextView)itemView.findViewById(R.id.region);
        TextView duracion = (TextView)itemView.findViewById(R.id.duracion);
        TextView precio = (TextView)itemView.findViewById(R.id.precio);
        ImageView onestar = (ImageView)itemView.findViewById(R.id.Onestar);
        ImageView twostar = (ImageView)itemView.findViewById(R.id.Twostar);
        ImageView threestar = (ImageView)itemView.findViewById(R.id.Threestar);
        ImageView forstar = (ImageView)itemView.findViewById(R.id.Forstar);
        ImageView fivestar = (ImageView)itemView.findViewById(R.id.Fivestar);
        ImageView imagen = (ImageView)itemView.findViewById(R.id.imagen);

        titulo.setText(tours.get(position).getTitulo());
        region.setText(tours.get(position).getCiudad());
        imagen.setImageResource(fotos[position]);
        duracion.setText("2 hrs.");
        precio.setText(formatoPrecio(String.valueOf(tours.get(position).getPrecio())));

        int stars = tours.get(position).getEstrellas();

        switch (stars){

            case 0:
                onestar.setImageResource(R.drawable.staroutline);
                twostar.setImageResource(R.drawable.staroutline);
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;

            case 1:
                twostar.setImageResource(R.drawable.staroutline);
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 2:
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 3:
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 4:
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 5:
                break;
        }

        return itemView;
    }

    public String formatoPrecio(String precio){
        String nuevoPrecio="";

        for(int i=0;i<precio.length();i++){
            nuevoPrecio=precio.charAt(precio.length()-i-1)+nuevoPrecio;
            if(i==2 || i==5){
                nuevoPrecio="."+nuevoPrecio;
            }
        }
        return "$"+nuevoPrecio;
    }
}
