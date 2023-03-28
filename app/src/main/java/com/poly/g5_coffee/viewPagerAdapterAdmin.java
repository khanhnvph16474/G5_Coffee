package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.g5_coffee.FragmentAdmin.HomeAdminFragment;
import com.poly.g5_coffee.FragmentAdmin.fragmentProfileAdmin;
import com.poly.g5_coffee.FragmentAdmin.fragmentOrder;
import com.poly.g5_coffee.FragmentAdmin.fragmentThongke;

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
                return new fragmentOrder();
            case 2:
                return new fragmentThongke();
            case 3:
                return new fragmentProfileAdmin();
            default:
               return new HomeAdminFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
