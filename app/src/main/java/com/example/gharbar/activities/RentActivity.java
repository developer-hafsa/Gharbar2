package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gharbar.R;
import com.example.gharbar.fragments.FlatsRentFragment;
import com.example.gharbar.fragments.HousesRentFragment;
import com.example.gharbar.fragments.ShopsRentFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RentActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        getSupportActionBar().hide();
        viewPager= findViewById(R.id.pager);
        setupViewPager(viewPager);
        tabLayout= findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager (ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HousesRentFragment(), "Houses");
        viewPagerAdapter.addFragment(new ShopsRentFragment(), "Shops");
        viewPagerAdapter.addFragment(new FlatsRentFragment(), "Flats");
        viewPager.setAdapter(viewPagerAdapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitle = new ArrayList<>();

        public ViewPagerAdapter (FragmentManager manager){
            super(manager);
        }

        public Fragment getItem(int position){
            return FragmentList.get(position);

        }
        public int getCount(){
            return FragmentList.size();
        }

        public void addFragment (Fragment fragment, String title){
            FragmentList.add(fragment);
            FragmentTitle.add(title);
        }
        public CharSequence getPageTitle(int position){
            return FragmentTitle.get(position);
        }

    }
}