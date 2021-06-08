package com.example.firebasedemo.FragmentTopic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class FragmentBottomAdapterTab extends FragmentPagerAdapter {
    public int numberPage=4;
    public FragmentBottomAdapterTab(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new FragmentTab("6sMVjTLSkeQ");
            case 1:
                return  new FragmentTab("towJZFskpGg");
            case 2:
                return  new FragmentTab("S4MKLAsBB74");
            case 3:
                return  new FragmentTab("hmenvQhUmxM");
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberPage;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Nature";
            case 1:
                return "People";
            case 2:
                return "Fashion";
            case 3:
                return "Film";
        }
        return null;
    }
}
