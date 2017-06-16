package com.example.ian.myapplication.Guias;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 16-06-2017.
 */
public class GuiaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.guia_display, container, false);
        ImageView back = (ImageView)view.findViewById(R.id.backArrow);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        ImageView foto = (ImageView)view.findViewById(R.id.img);
        final RelativeLayout perfil = (RelativeLayout)view.findViewById(R.id.imagenLayout);

        foto.setImageResource(R.drawable.persona);


        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.MyAppbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
                    perfil.setVisibility(View.GONE);
                } else if (verticalOffset == 0) {
                    //  // Expanded
                    perfil.setVisibility(View.VISIBLE);
                } else {
                    // Somewhere in between
                    perfil.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;

    }
}
