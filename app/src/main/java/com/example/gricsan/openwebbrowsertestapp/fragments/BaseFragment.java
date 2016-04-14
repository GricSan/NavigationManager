package com.example.gricsan.openwebbrowsertestapp.fragments;


import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    protected static String TAG;

    public BaseFragment() {
        // Required empty public constructor
    }

    protected void setTag(String tag){
        TAG = tag;
    }

    public String getFragmentTag(){
        return TAG;
    }

}
