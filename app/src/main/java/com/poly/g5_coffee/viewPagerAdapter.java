package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.g5_coffee.Fragment.CartFragment;
import com.poly.g5_coffee.Fragment.fragmentHistory;
import com.poly.g5_coffee.Fragment.fragmentHome;
import com.poly.g5_coffee.Fragment.fragmentNotification;
import com.poly.g5_coffee.Fragment.FragmentProfile;

public class viewPagerAdapter extends FragmentStatePagerAdapter {
    public viewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragmentHome();
            case 1:
                return new fragmentNotification();
            case 2:
                return new CartFragment();
            case 3:
                return new fragmentHistory();
            case 4:
                return new FragmentProfile();
            default:
               return new fragmentHome();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
