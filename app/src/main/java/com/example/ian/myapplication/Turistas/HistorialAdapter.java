package com.example.ian.myapplication.Turistas;

import android.content.Context;
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
 * Created by Ian on 16-06-2017.
 */
public class HistorialAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;


    int[] fotos = {
            R.drawable.paisaje1,
            R.drawable.paisaje2
    };


    ArrayList<Tour> tours;

    public HistorialAdapter(Context context, ArrayList<Tour> tours) {
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

        View itemView = inflater.inflate(R.layout.style_history, parent, false);

        TextView titulo = (TextView)itemView.findViewById(R.id.textNombre);
        TextView region = (TextView)itemView.findViewById(R.id.textComuna);
        TextView calificada = (TextView)itemView.findViewById(R.id.textCalificada);
        ImageView onestar = (ImageView)itemView.findViewById(R.id.star1);
        ImageView twostar = (ImageView)itemView.findViewById(R.id.star2);
        ImageView threestar = (ImageView)itemView.findViewById(R.id.star3);
        ImageView forstar = (ImageView)itemView.findViewById(R.id.star4);
        ImageView fivestar = (ImageView)itemView.findViewById(R.id.star5);

        titulo.setText(tours.get(position).getTitulo());
        region.setText(tours.get(position).getCiudad());
        if(tours.get(position).getFueCalificada()){
            calificada.setText("Calificada");
            int stars = tours.get(position).getCalificacionTurista();

            onestar.setBackground(itemView.getResources().getDrawable(R.color.colorPrimaryDark));
            twostar.setBackground(itemView.getResources().getDrawable(R.color.colorPrimaryDark));
            threestar.setBackground(itemView.getResources().getDrawable(R.color.colorPrimaryDark));
            forstar.setBackground(itemView.getResources().getDrawable(R.color.colorPrimaryDark));
            fivestar.setBackground(itemView.getResources().getDrawable(R.color.colorPrimaryDark));

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
        }else{
            calificada.setText("No calificada");
        }

        return itemView;
    }


}
