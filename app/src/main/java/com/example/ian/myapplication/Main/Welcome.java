package com.example.ian.myapplication.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 09-05-2017.
 */
public class Welcome extends Activity{
    Button login;
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        login = (Button)findViewById(R.id.login);
        registro = (Button)findViewById(R.id.registro);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, SeleccionRegistro.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
