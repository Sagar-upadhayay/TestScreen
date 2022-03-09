package com.testscreen;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {


    public Adapter(@NonNull FragmentManager fm, Context applicationContext) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        String title = null;


        if (position == 0) {
            title = "SignIn";
        }

        if (position == 1) {
            title = "SignUp";
        }
        return title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SignInFragment();
        }
        if (position == 1) {
            return new SignUpFragment();
        }
        return new SignInFragment();
    }
}
