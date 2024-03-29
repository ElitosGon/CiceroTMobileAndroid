package com.example.ian.myapplication.Main;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.CuentaGuia.Main.MainGuia;
import com.example.ian.myapplication.DetailActivity;
import com.example.ian.myapplication.R;

/**
 * Created by Ian on 24-10-2016.
 */
public class LoginActivity extends Activity {


    Button Login;
    TextView Registro;
    ImageView back;
    EditText usuario;
    EditText pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = (Button) findViewById(R.id.LoginButton);
        Registro = (TextView) findViewById(R.id.Remember);
        back = (ImageView)findViewById(R.id.backIcon);
        usuario = (EditText)findViewById(R.id.nombre);
        pass = (EditText)findViewById(R.id.pass);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SeleccionRegistro.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().equals("guia")){
                    Intent intent = new Intent(LoginActivity.this, MainGuia.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
