package com.example.ian.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.MainLists.UltimosAdapter;

import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */


public class LugarActivity extends Activity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        ImageView back = (ImageView)findViewById(R.id.backIcon);
        ListView list =(ListView)findViewById(R.id.list);

        // dummy
        ArrayList<Tour> tours = setTours();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Playadapter adapter = new Playadapter(this, tours);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(LugarActivity.this,playa.class);
                startActivity(intent);
                finish();
            }

        });


    }

    public ArrayList<Tour> setTours(){
        ArrayList<Tour> tours = new ArrayList<>();

        Tour tour1 = new Tour("La mejor playa!",75000,"Un buen tour", "Valparaíso",2,3);
        Tour tour2 = new Tour("Paseo en la playa",20000,"Un buen tour", "Viña del mar",3,5);
        Tour tour3 = new Tour("Tour guíado en la playa",30000,"Un buen tour", "Costa Azul",1,4);

        tours.add(tour1);
        tours.add(tour2);
        tours.add(tour3);

        return tours;
    }
}