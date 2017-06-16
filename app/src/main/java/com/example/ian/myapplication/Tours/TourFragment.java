package com.example.ian.myapplication.Tours;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ian.myapplication.R;

import org.w3c.dom.Text;

/**
 * Created by Ian on 15-06-2017.
 */
public class TourFragment extends Fragment {

    ImageView imagen;
    RelativeLayout titlePanel;
    TextView titulo;
    TextView tituloCollapse;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_displaytour, container, false);
        imagen = (ImageView)view.findViewById(R.id.bgheader);
        titlePanel = (RelativeLayout)view.findViewById(R.id.titlePanel);
        titulo = (TextView)view.findViewById(R.id.titulo);
        tituloCollapse = (TextView)view.findViewById(R.id.tituloCollapse);
        back = (ImageView)view.findViewById(R.id.backArrow);

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


}
