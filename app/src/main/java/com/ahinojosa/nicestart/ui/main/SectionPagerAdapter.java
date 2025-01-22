package com.ahinojosa.nicestart.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ahinojosa.nicestart.fragments.Page1;
import com.ahinojosa.nicestart.fragments.Page2;
import com.ahinojosa.nicestart.fragments.Page3;
import com.ahinojosa.nicestart.fragments.Page4;

public class SectionPagerAdapter extends FragmentPagerAdapter{
    private final Context mcontext;

    public SectionPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mcontext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Page1();
            case 1:
                return new Page2();
            case 2:
                return new Page3();
            case 3:
                return new Page4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
