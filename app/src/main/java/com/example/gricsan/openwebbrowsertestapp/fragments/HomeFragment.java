package com.example.gricsan.openwebbrowsertestapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gricsan.openwebbrowsertestapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    public final static String TAG = "HomeFragment";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setTag(TAG);
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
