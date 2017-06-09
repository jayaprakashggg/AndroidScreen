package com.jayaprakash.androidtask.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.gustavofao.materialtabs.SlidingFragmentPagerAdapter;
import com.jayaprakash.androidtask.R;
import com.jayaprakash.androidtask.fragment.TabImageFragment;
import com.jayaprakash.androidtask.fragment.TabMilestoneFragment;
import com.jayaprakash.androidtask.fragment.TabVideoFragment;


public class TabAdapter extends SlidingFragmentPagerAdapter {

    private String[] titles = {
            "VIDEOS",
            "IMAGES",
            "MILESTONE",
    };

    private int[] icons = {
            R.drawable.tab_video,
            R.drawable.tab_image,
            R.drawable.tab_milestone
    };
    private Context context;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
//        Bundle bundle = new Bundle();
//        bundle.putInt(TabVideoFragment.POSITION, position + 1);
//        Fragment fragment = new TabVideoFragment();
//        fragment.setArguments(bundle);

        switch (position) {
            case 0:
                Fragment fragment = new TabVideoFragment();
                return fragment;
            case 1:
                Fragment fragment2 = new TabImageFragment();
                return fragment2;
            case 2:
                Fragment fragment3 = new TabMilestoneFragment();
                return fragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return icons.length == titles.length ? icons.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Drawable getPageDrawable(int position) {
        return context.getResources().getDrawable(icons[position]);
    }

    @Override
    public String getToolbarTitle(int position) {
        return titles[position];
    }
}
