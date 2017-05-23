
package com.example.ian.myapplication.Tours;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.ian.myapplication.Main.LoginActivity;
import com.example.ian.myapplication.EDA.Tour;
import com.example.ian.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */
public class UltimosTours extends Fragment {
    ListView list;
    UltimosToursAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        list =(ListView)view.findViewById(R.id.list);

        // dummy
        final ArrayList<Tour> tours = setTours();


        adapter = new UltimosToursAdapter(getContext(), tours);
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
                    Snackbar.make(view,"abajo",Snackbar.LENGTH_LONG);
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

    public ArrayList<Tour> setTours(){
        ArrayList<Tour> tours = new ArrayList<>();

        Tour tour1 = new Tour("El mejor tour",50000,"Un buen tour", "Valparaíso",2,3,"Ian Orellana",0);
        Tour tour2 = new Tour("Viaje entretenido",30000,"Un buen tour", "París",3,5,"Elías González",0);

        tours.add(tour1);
        tours.add(tour2);

        return tours;
    }
}
