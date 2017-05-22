package com.example.ian.myapplication.Guias;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 21-05-2017.
 */
public class EditarConfiguracion extends Fragment {

    Switch notify;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_editarconfiguracion, container, false);

        notify = (Switch)view.findViewById(R.id.notify);

        //Cambiar cuando se active la API
        notify.setChecked(true);

        return view;
    }
}
