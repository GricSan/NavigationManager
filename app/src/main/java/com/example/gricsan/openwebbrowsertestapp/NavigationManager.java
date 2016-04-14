package com.example.gricsan.openwebbrowsertestapp;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.example.gricsan.openwebbrowsertestapp.fragments.BaseFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.FavoriteFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.HomeFragment;
import com.example.gricsan.openwebbrowsertestapp.fragments.SettingsFragment;

import java.util.LinkedList;

public class NavigationManager {

    private static NavigationManager sNavigationManager;

    private LinkedList<String> mFragmentTransactions;

    private int mContentContainerId;

    private FragmentManager mFragmentManager;

    private NavigationManager() {

    }

    public static NavigationManager getInstance() {
        if (sNavigationManager == null) {
            sNavigationManager = new NavigationManager();
            sNavigationManager.mFragmentTransactions = new LinkedList<>();
        }
        return sNavigationManager;
    }

    public static void init(int contentContainerId, FragmentManager fragmentManager) {
        sNavigationManager = getInstance();
        sNavigationManager.mContentContainerId = contentContainerId;
        sNavigationManager.mFragmentManager = fragmentManager;
    }


    /**
     * @param pendingFragment a fragment that's about to appear.
     * @return True if pending fragment is empty (or history is empty), otherwise - False.
     */
    private boolean isValidTransaction(BaseFragment pendingFragment) {
        return sNavigationManager.mFragmentTransactions.size() == 0
                || !sNavigationManager.mFragmentTransactions.getLast().equals(pendingFragment.getFragmentTag());
    }

    /**
     * @param newFragment will be shown if isValidTransaction.
     */
    public void switchFragment(BaseFragment newFragment) {
        if (isValidTransaction(newFragment)) {
            if (mFragmentTransactions.contains(newFragment.getFragmentTag())) {
                mFragmentTransactions.remove(newFragment.getFragmentTag());
            }

            mFragmentManager.beginTransaction()
                    .replace(sNavigationManager.mContentContainerId, newFragment, newFragment.getFragmentTag())
                    .commit();

            mFragmentTransactions.add(newFragment.getFragmentTag());
        }
    }

    public void goBack(Activity activity) {
        if (mFragmentTransactions.size() <= 1) {
            activity.moveTaskToBack(true);
        } else {
            mFragmentTransactions.removeLast();
            BaseFragment newFragment = FragmentFactory.getNewFragment(mFragmentTransactions.getLast());

            mFragmentManager.beginTransaction()
                    .replace(sNavigationManager.mContentContainerId, newFragment, newFragment.getFragmentTag())
                    .commit();
        }
    }

    private static class FragmentFactory {

        public static BaseFragment getNewFragment(String tag) {
            BaseFragment fragment;

            switch (tag) {
                case HomeFragment.TAG: {
                    fragment = HomeFragment.newInstance();
                    break;
                }
                case FavoriteFragment.TAG: {
                    fragment = FavoriteFragment.newInstace();
                    break;
                }
                case SettingsFragment.TAG: {
                    fragment = SettingsFragment.newInstace();
                    break;
                }
                default: {
                    fragment = HomeFragment.newInstance();
                    break;
                }
            }

            return fragment;
        }

    }


}
