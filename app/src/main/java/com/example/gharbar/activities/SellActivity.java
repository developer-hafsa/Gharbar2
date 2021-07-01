package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.gharbar.R;

public class SellActivity extends AppCompatActivity {

    //TabLayout tabLayout;
    //ViewPager viewPager;
    LinearLayout linLayout1, linLayout2, linLayout3, linLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        getSupportActionBar().hide();
        //viewPager= findViewById(R.id.pager);
        //setupViewPager(viewPager);
        //tabLayout= findViewById(R.id.tab_layout);
        //tabLayout.setupWithViewPager(viewPager);
        linLayout1= findViewById(R.id.sell_house);
        linLayout2 = findViewById(R.id.sell_shop);
        linLayout3 = findViewById(R.id.sell_flat);
        linLayout4 = findViewById(R.id.sell_plot);


        linLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellActivity.this, sell_house.class);
                startActivity(intent);
            }
        });


//        linLayout2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent intent = new Intent(SellActivity.this, ShopSellFragment.class);
////                startActivity(intent);
//            }
//        });
//
//        linLayout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(SellActivity.this, FlatSellFragment.class);
////                startActivity(intent);
//            }
//        });
//
//        linLayout4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(SellActivity.this, PlotSellFragment.class);
////                startActivity(intent);
//            }
//        });
//
   }

//    public void setupViewPager(ViewPager viewPager){
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPagerAdapter.addFragment(new HouseSellFragment(), "Houses");
//        viewPagerAdapter.addFragment(new ShopSellFragment(), "Shops");
//        viewPagerAdapter.addFragment(new PlotSellFragment(), "Plots");
//        viewPagerAdapter.addFragment(new FlatSellFragment(), "Flats");
//        viewPager.setAdapter(viewPagerAdapter);
//
//    }
//
//    class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        private final List<Fragment> FragmentList = new ArrayList<>();
//        private final List<String>  FragmentTitle= new ArrayList<>();
//
//        public ViewPagerAdapter(FragmentManager manager){
//            super(manager);
//        }
//
//        public Fragment getItem(int position){
//            return FragmentList.get(position);
//        }
//
//        public int getCount(){
//            return FragmentList.size();
//        }
//        public void addFragment(Fragment fragment, String title){
//            FragmentList.add(fragment);
//            FragmentTitle.add(title);
//        }
//
//        public CharSequence getPageTitle(int position){
//            return FragmentTitle.get(position);
//        }
//
//
//    }
}