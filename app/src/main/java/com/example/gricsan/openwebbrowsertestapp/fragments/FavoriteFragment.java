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
public class FavoriteFragment extends BaseFragment {

    public static final String TAG = "FavoriteFragment";

    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstace() {
        FavoriteFragment favoriteFragment = new FavoriteFragment();
        favoriteFragment.setTag(TAG);
        return favoriteFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

}
