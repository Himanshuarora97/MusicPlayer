package com.makroid.musicplayer;

import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.makroid.musicplayer.Adapters.SongPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new BottomFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment).commit();
        initToolbar();
        setViewPager();
    }

    private void setViewPager() {
        SongPagerAdapter adapter = new SongPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SongFragment().newInstance(1),"songs");
        adapter.addFragment(new SongFragment().newInstance(2),"Artist");
        adapter.addFragment(new SongFragment().newInstance(3),"Album");
        adapter.addFragment(new SongFragment().newInstance(4),"Playlist");
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburger);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

//Todo Add Navigation Drawer and choose theme for Primary etc...
//Todo Add View Pager and Tab Layout
//Todo Add Permission
//Todo Media Integration
//Todo MetaData provides information
//Todo Make Fun
