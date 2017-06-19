package com.example.ian.myapplication.Tours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

/**
 * Created by Ian on 12-05-2017.
 */
public class PlantillaTour extends Activity {

    Button agendar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_display);

        agendar = (Button)findViewById(R.id.agendar);

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlantillaTour.this,NotaVenta.class);
                startActivity(intent);
            }
        });

    }
}
