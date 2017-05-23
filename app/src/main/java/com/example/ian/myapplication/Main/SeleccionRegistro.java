package com.example.ian.myapplication.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 09-05-2017.
 */
public class SeleccionRegistro extends Activity{

    TextView Login;
    ImageView back;
    Button registroTurista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Login = (TextView)findViewById(R.id.Remember);
        back = (ImageView)findViewById(R.id.backIcon);
        registroTurista = (Button)findViewById(R.id.registroTurista);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeleccionRegistro.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registroTurista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeleccionRegistro.this,RegistroTurista.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
