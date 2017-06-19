package com.example.ian.myapplication.Tours;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ian.myapplication.Guias.PlantillaGuia;
import com.example.ian.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

/**
 * Created by Ian on 15-06-2017.
 */
public class TourFragment extends Fragment  {

    ImageView imagen;
    RelativeLayout titlePanel;
    TextView titulo;
    TextView tituloCollapse;
    ImageView back;
    MapView mMapView;
    private GoogleMap googleMap;
    ImageView imagenGuia;
    TextView precio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_displaytour, container, false);
        imagen = (ImageView)view.findViewById(R.id.bgheader);
        titlePanel = (RelativeLayout)view.findViewById(R.id.titlePanel);
        titulo = (TextView)view.findViewById(R.id.titulo);
        tituloCollapse = (TextView)view.findViewById(R.id.tituloCollapse);
        back = (ImageView)view.findViewById(R.id.backArrow);
        imagenGuia = (ImageView)view.findViewById(R.id.imagenGuia);
        precio = (TextView)view.findViewById(R.id.precios);

        imagenGuia.setImageResource(R.drawable.persona);

        imagenGuia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlantillaGuia.class);
                startActivity(intent);
            }
        });

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                try {
                    googleMap.setMyLocationEnabled(true);
                }catch (SecurityException s){
                    System.out.print("Security exception");
                }

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(-34, 151);
                googleMap.addMarker(new MarkerOptions().position(sydney).title(titulo.getText().toString()).snippet(precio.getText().toString()));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.MyAppbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
                    imagen.setBackground(getResources().getDrawable(R.color.colorPrimary));
                    titlePanel.setBackground(getResources().getDrawable(R.color.colorPrimary));
                    titulo.setVisibility(View.GONE);
                    tituloCollapse.setVisibility(View.VISIBLE);
                } else if (verticalOffset == 0) {
                    //  // Expanded
                    imagen.setBackground(getResources().getDrawable(R.drawable.paisaje1));
                    // titlePanel.setVisibility(View.VISIBLE);
                    titlePanel.setBackground(getResources().getDrawable(R.drawable.custom_fit));
                    titulo.setVisibility(View.VISIBLE);
                    tituloCollapse.setVisibility(View.GONE);
                } else {
                    // Somewhere in between
                    imagen.setBackground(getResources().getDrawable(R.drawable.paisaje1));
                    // titlePanel.setVisibility(View.VISIBLE);
                    titlePanel.setBackground(getResources().getDrawable(R.drawable.custom_fit));
                    titulo.setVisibility(View.VISIBLE);
                    tituloCollapse.setVisibility(View.GONE);
                }
            }
        });

        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
