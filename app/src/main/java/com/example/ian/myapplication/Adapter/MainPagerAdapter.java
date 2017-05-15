package com.example.ian.myapplication.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ian.myapplication.MainLists.Mejores;
import com.example.ian.myapplication.MainLists.Ultimos;
import com.example.ian.myapplication.test;
import com.example.ian.myapplication.test2;


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
                Ultimos tab1 = new Ultimos();
                return tab1;
            case 1:
                Mejores tab2 = new Mejores();
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