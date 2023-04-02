package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.g5_coffee.FragmentAdmin.HomeAdminFragment;
import com.poly.g5_coffee.FragmentAdmin.FragmentProfileAdmin;
import com.poly.g5_coffee.FragmentAdmin.FragmentOrder;
import com.poly.g5_coffee.FragmentAdmin.FragmentThongke;

public class viewPagerAdapterAdmin extends FragmentStatePagerAdapter {
    public viewPagerAdapterAdmin(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeAdminFragment();
            case 1:
                return new FragmentOrder();
            case 2:
                return new FragmentThongke();
            case 3:
                return new FragmentProfileAdmin();
            default:
               return new HomeAdminFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
