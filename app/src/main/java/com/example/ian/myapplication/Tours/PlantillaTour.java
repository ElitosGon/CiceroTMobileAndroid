package com.example.ian.myapplication.Tours;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

/**
 * Created by Ian on 12-05-2017.
 */
public class PlantillaTour extends Activity {

    TextView titulo;
    TextView descripcion;
    TextView nombreGuia;
    ImageView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        back = (ImageView)findViewById(R.id.backIcon);
        titulo = (TextView)findViewById(R.id.titulo);
        descripcion = (TextView)findViewById(R.id.descripcion);
        nombreGuia = (TextView)findViewById(R.id.nombreguia);

        Tour tour = (Tour)getIntent().getSerializableExtra("tour");

        titulo.setText(tour.getTitulo());
        descripcion.setText(tour.getDescripcion());
        nombreGuia.setText(tour.getNombreGuia());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
