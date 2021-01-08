package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gharbar.R;
import com.example.gharbar.fragments.FlatsFragment;
import com.example.gharbar.fragments.HousesFragment;
import com.example.gharbar.fragments.PlotsFragment;
import com.example.gharbar.fragments.ShopsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BuyActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        getSupportActionBar().hide();
        viewPager= findViewById(R.id.pager);
        setupViewPager(viewPager);
        tabLayout= findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HousesFragment(), "Houses");
        viewPagerAdapter.addFragment(new ShopsFragment(), "Shops");
        viewPagerAdapter.addFragment(new PlotsFragment(),"Plots");
        viewPagerAdapter.addFragment(new FlatsFragment(), "Flats");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList =new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }
        public Fragment getItem(int position){
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }
}