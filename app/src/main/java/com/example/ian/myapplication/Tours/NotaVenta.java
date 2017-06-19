package com.example.ian.myapplication.Tours;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 16-06-2017.
 */
public class NotaVenta extends Activity {

    Button aceptar;
    Button cancelar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_nota);

        aceptar = (Button)findViewById(R.id.acceptButton);
        cancelar = (Button)findViewById(R.id.cancelButton);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Se ha realizado la compra del tour",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
