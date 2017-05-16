package com.example.ian.myapplication.Guias;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 16-05-2017.
 */
public class PlantillaGuia extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia);

        ImageView back = (ImageView)findViewById(R.id.backIcon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
