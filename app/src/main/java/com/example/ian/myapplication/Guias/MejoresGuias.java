package com.example.ian.myapplication.Guias;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ian.myapplication.EDA.Guia;
import com.example.ian.myapplication.Main.LoginActivity;
import com.example.ian.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */
public class MejoresGuias extends Fragment {
    ListView list;
    MejoresGuiasAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        list =(ListView)view.findViewById(R.id.list);

        // dummy
        final ArrayList<Guia> guias = setTours();


        adapter = new MejoresGuiasAdapter(getContext(), guias);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), PlantillaGuia.class);
                intent.putExtra("guia",guias.get(position));
                startActivity(intent);
            }
        });

        return view;
    }

    public ArrayList<Guia> setTours(){
        ArrayList<Guia> tours = new ArrayList<>();

        Guia tour1 = new Guia("Israel Martínez","El mejor guía de Chile",5,"Santiago",20 );
        Guia tour2 = new Guia("Pablo Zurita","Muerte a todos los turistas",4,"Santiago",15 );

        tours.add(tour1);
        tours.add(tour2);

        return tours;
    }
}
