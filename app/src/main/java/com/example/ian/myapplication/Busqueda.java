package com.example.ian.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Ian on 12-05-2017.
 */
public class Busqueda extends Activity {

    ImageView back;
    EditText search;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        back  = (ImageView)findViewById(R.id.backIcon);
        search = (EditText)findViewById(R.id.searchBar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {

                        ///Simula una busqueda
                            Intent intent = new Intent(Busqueda.this, LugarActivity.class);
                            startActivity(intent);


                        return true;
                    }
                return false;
            }
        });
    }

}
