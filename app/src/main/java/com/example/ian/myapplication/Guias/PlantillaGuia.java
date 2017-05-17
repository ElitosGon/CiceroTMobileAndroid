package com.example.ian.myapplication.Guias;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.EDA.Guia;
import com.example.ian.myapplication.R;

/**
 * Created by Ian on 16-05-2017.
 */
public class PlantillaGuia extends Activity {

    TextView nombre;
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView star4;
    ImageView star5;
    TextView descripcion;
    ImageView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia);

        nombre = (TextView)findViewById(R.id.nombreText);
        star1 = (ImageView)findViewById(R.id.star1);
        star2 = (ImageView)findViewById(R.id.star2);
        star3 = (ImageView)findViewById(R.id.star3);
        star4 = (ImageView)findViewById(R.id.star4);
        star5 = (ImageView)findViewById(R.id.star5);
        descripcion = (TextView)findViewById(R.id.descripcion);
        back = (ImageView)findViewById(R.id.backIcon);

        Guia guia = (Guia)getIntent().getSerializableExtra("guia");

        nombre.setText(guia.getNombre());
        descripcion.setText(guia.getDescripcion());

        switch (guia.getEstrellas()){
            case 0:
                star1.setImageResource(R.drawable.staroutline);
                star2.setImageResource(R.drawable.staroutline);
                star3.setImageResource(R.drawable.staroutline);
                star4.setImageResource(R.drawable.staroutline);
                star5.setImageResource(R.drawable.staroutline);
                break;
            case 1:
                star2.setImageResource(R.drawable.staroutline);
                star3.setImageResource(R.drawable.staroutline);
                star4.setImageResource(R.drawable.staroutline);
                star5.setImageResource(R.drawable.staroutline);
                break;
            case 2:
                star3.setImageResource(R.drawable.staroutline);
                star4.setImageResource(R.drawable.staroutline);
                star5.setImageResource(R.drawable.staroutline);
                break;
            case 3:
                star4.setImageResource(R.drawable.staroutline);
                star5.setImageResource(R.drawable.staroutline);
                break;
            case 4:
                star5.setImageResource(R.drawable.staroutline);
                break;
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
