package com.example.ian.myapplication.CuentaGuia.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;
import com.example.ian.myapplication.Tours.PlantillaTour;
import com.example.ian.myapplication.Turistas.HistorialAdapter;

import java.util.ArrayList;

/**
 * Created by Ian on 18-06-2017.
 */
public class ActividadGuia extends Fragment {

    ListView list;
    ActividadAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        list =(ListView)view.findViewById(R.id.list);

        // dummy
        final ArrayList<Tour> tours = setHistorial();


        adapter = new ActividadAdapter(getContext(), tours);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), PlantillaTour.class);
                intent.putExtra("tour", tours.get(position));
                startActivity(intent);
            }
        });

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int mLastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(mLastFirstVisibleItem<firstVisibleItem)
                {
                    Snackbar.make(view, "abajo", Snackbar.LENGTH_LONG);
                }
                if(mLastFirstVisibleItem>firstVisibleItem)
                {
                    Snackbar.make(view, "arriba", Snackbar.LENGTH_LONG);
                }
                mLastFirstVisibleItem=firstVisibleItem;

            }
        });

        return view;
    }

    public ArrayList<Tour> setHistorial(){
        ArrayList<Tour> tours = new ArrayList<>();

        Tour tour1 = new Tour("El mejor tour",50000,"Un buen tour", "Valparaíso",2,3,"Ian Orellana",0,0,false);
        Tour tour2 = new Tour("Viaje entretenido",30000,"Un buen tour", "París",3,5,"Elías González",0,3,true);

        tours.add(tour1);
        tours.add(tour2);

        return tours;
    }
}
