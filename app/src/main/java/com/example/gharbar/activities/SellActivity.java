package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gharbar.R;
import com.example.gharbar.fragments.FlatSellFragment;
import com.example.gharbar.fragments.HouseSellFragment;
import com.example.gharbar.fragments.PlotSellFragment;
import com.example.gharbar.fragments.ShopSellFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SellActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        getSupportActionBar().hide();
        viewPager= findViewById(R.id.pager);
        setupViewPager(viewPager);
        tabLayout= findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HouseSellFragment(), "Houses");
        viewPagerAdapter.addFragment(new ShopSellFragment(), "Shops");
        viewPagerAdapter.addFragment(new PlotSellFragment(), "Plots");
        viewPagerAdapter.addFragment(new FlatSellFragment(), "Flats");
        viewPager.setAdapter(viewPagerAdapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String>  FragmentTitle= new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        public Fragment getItem(int position){
            return FragmentList.get(position);
        }

        public int getCount(){
            return FragmentList.size();
        }
        public void addFragment(Fragment fragment, String title){
            FragmentList.add(fragment);
            FragmentTitle.add(title);
        }

        public CharSequence getPageTitle(int position){
            return FragmentTitle.get(position);
        }


    }
}