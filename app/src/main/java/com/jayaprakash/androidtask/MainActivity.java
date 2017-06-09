package com.jayaprakash.androidtask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.gustavofao.materialtabs.SlidingTabLayout;
import com.gustavofao.materialtabs.TabType;
import com.jayaprakash.androidtask.adapter.TabAdapter;
import com.jayaprakash.androidtask.custom.CustomTextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPagerEx.OnPageChangeListener {

    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter adapter;
    private SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Chain smoker new album 2016",R.mipmap.sliding_one);
        file_maps.put("Indian boys new album 2017",R.mipmap.sliding_two);
        file_maps.put("Welcome to india new album song",R.mipmap.sliding_three);
        file_maps.put("Dum Dum create new song", R.mipmap.sliding_four);

        for(String name : file_maps.keySet()){
            CustomTextView textSliderView = new CustomTextView(this);
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);





        tabLayout = (SlidingTabLayout) findViewById(R.id.tab_host);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        adapter = new TabAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter); // Necessario

        tabLayout.setTextSize(15);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setTabType(TabType.TEXT_ICON);
        tabLayout.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));
        tabLayout.setActionBar(getSupportActionBar());
        tabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorPrimary));
        tabLayout.setCustomFocusedColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setCustomUnfocusedColor(getResources().getColor(R.color.colorGrey));
        tabLayout.setViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
