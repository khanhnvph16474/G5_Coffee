package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityAdmin extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        mNavigationView = findViewById(R.id.Bottom_Nav_Admin);
        mViewPager = findViewById(R.id.view_pager_admin);
        setUpViewPager();
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.ic_homeAdmin:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.ic_order:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.ic_thongke:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.ic_profile_admin:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void setUpViewPager(){
        viewPagerAdapterAdmin viewPagerAdapterAdmin =
                new viewPagerAdapterAdmin(getSupportFragmentManager(),
                        FragmentStatePagerAdapter
                                .BEHAVIOR_SET_USER_VISIBLE_HINT);
        mViewPager.setAdapter(viewPagerAdapterAdmin);

    }
}