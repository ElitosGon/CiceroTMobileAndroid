
package com.example.ian.myapplication.MainLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */
public class Ultimos extends Fragment {
    ListView list;
    UltimosAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        list =(ListView)view.findViewById(R.id.list);



        // dummy
        ArrayList<Tour> tours = setTours();


        adapter = new UltimosAdapter(getContext(), tours);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });

        return view;
    }

    public ArrayList<Tour> setTours(){
        ArrayList<Tour> tours = new ArrayList<>();

        Tour tour1 = new Tour("El mejor tour",50000,"Un buen tour", "Valparaíso",2,3);
        Tour tour2 = new Tour("Viaje entretenido",30000,"Un buen tour", "París",3,5);
        Tour tour3 = new Tour("Visita al molino",75000,"Un buen tour", "Aquí",1,4);

        tours.add(tour1);
        tours.add(tour2);
        tours.add(tour3);

        return tours;
    }
}
