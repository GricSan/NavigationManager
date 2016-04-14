package com.example.gricsan.openwebbrowsertestapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.gricsan.openwebbrowsertestapp.fragments.BaseFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.FavoriteFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.HomeFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.SettingsFragment;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FrameLayout mContentFragment;
    private NavigationView mNavigationView;
    private LinkedList<Integer> mSelectedMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mContentFragment = (FrameLayout) findViewById(R.id.content_fragment);
        if (mContentFragment != null) {
            NavigationManager.init(mContentFragment.getId(), getSupportFragmentManager());
        }

        mSelectedMenuItems = new LinkedList<>();
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                mSelectedMenuItems.add(item.getItemId());
                BaseFragment fragment;

                switch (item.getTitle().toString()) {
                    case "Home": {
                        fragment = HomeFragment.newInstance();
                        break;
                    }
                    case "Favorite": {
                        fragment = FavoriteFragment.newInstace();
                        break;
                    }
                    case "Settings": {
                        fragment = SettingsFragment.newInstace();
                        break;
                    }
                    default: {
                        fragment = null;
                        break;
                    }

                }
                NavigationManager.getInstance().switchFragment(fragment);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


        NavigationManager.getInstance().switchFragment(HomeFragment.newInstance());
        mSelectedMenuItems.add(mNavigationView.getMenu().getItem(0).getItemId());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            NavigationManager.getInstance().goBack(this);
            mSelectedMenuItems.removeLast();
            mNavigationView.setCheckedItem(mSelectedMenuItems.getLast());
        }
    }

}
