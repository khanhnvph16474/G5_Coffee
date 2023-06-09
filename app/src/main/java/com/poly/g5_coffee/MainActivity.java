package com.poly.g5_coffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationView = findViewById(R.id.Bottom_Nav);
        mViewPager = findViewById(R.id.view_pager);
        setUpViewPager();
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.ic_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.ic_notification:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.ic_shopping:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.ic_history:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.ic_profile:
                        mViewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

    private void setUpViewPager(){
        viewPagerAdapter viewPagerAdapter =
                new viewPagerAdapter(getSupportFragmentManager(),
                        FragmentStatePagerAdapter
                                .BEHAVIOR_SET_USER_VISIBLE_HINT);
        mViewPager.setAdapter(viewPagerAdapter);

    }
}