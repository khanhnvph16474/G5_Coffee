package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.poly.g5_coffee.FragmentLogin.DangNhap_Fragment;
import com.poly.g5_coffee.FragmentLogin.Dangki_Fragment;



public class ViewPageFragment extends FragmentStateAdapter {

    public ViewPageFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPageFragment(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPageFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new DangNhap_Fragment();
        }
        return new Dangki_Fragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

