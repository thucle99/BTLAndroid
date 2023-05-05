package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentBottomAdapter extends FragmentStatePagerAdapter {
    public int numberPage=3;

    public FragmentBottomAdapter(@NonNull FragmentManager fm,int behavior) {
        super(fm,behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentHome();
            default:
                return new FragmentContact();
        }
    }

    @Override
    public int getCount() {
        return numberPage;
    }
}
