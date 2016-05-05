package com.my.listandrecycler.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.my.listandrecycler.R;
import com.my.listandrecycler.adapter.MyFragmentPageAdapter;
import com.my.listandrecycler.fragment.ExpandableListViewFragment;
import com.my.listandrecycler.fragment.ListViewFragment;
import com.my.listandrecycler.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> data;
    private ViewPager viewPager;
    private MyFragmentPageAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_ViewPager);
        tabLayout = (TabLayout) findViewById(R.id.main_TabLayout);

        //TODO 加fragment页面
        data  = new ArrayList<>();
        data.add(new ListViewFragment());
        data.add(new ExpandableListViewFragment());
        data.add(new RecyclerViewFragment());

        adapter = new MyFragmentPageAdapter(getSupportFragmentManager(),data,this);
        viewPager.setAdapter(adapter);

        tabLayout.setTabTextColors(Color.GRAY, Color.GREEN);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setSelectedTabIndicatorColor(Color.alpha(1));
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if(tab != null){
                tab.setCustomView(adapter.getTabView(i));
            }
        }
    }
}
