package com.example.a61555.maintenance_demo10.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class PagerViewAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;
    private Fragment currentFragment;
    private int type;//1:PARAMETER; 2:INSPECTION

    public PagerViewAdapter(FragmentManager fm, Fragment[] fragments, int type) {
        super(fm);
        this.fragments = fragments;
        this.type = type;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (type == 2) {
            position = position*4;
        }
        if (position < 10)
            return "0"+position+":00";
        else
            return position+":00";
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        currentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
