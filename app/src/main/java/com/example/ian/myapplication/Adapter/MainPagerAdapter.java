package com.example.ian.myapplication.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ian.myapplication.Guias.MejoresGuias;
import com.example.ian.myapplication.Tours.UltimosTours;


public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                UltimosTours tab1 = new UltimosTours();
                return tab1;
            case 1:
                MejoresGuias tab2 = new MejoresGuias();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}