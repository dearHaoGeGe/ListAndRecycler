package com.my.listandrecycler.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.my.listandrecycler.R;

import java.util.ArrayList;

/**
 * Created by dllo on 15/12/29.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> data;
    String [] title = {"ListView","ExpandableListView","RecyclerView"};
    private Context context;

    public MyFragmentPageAdapter(FragmentManager fm, ArrayList<Fragment> data, Context context) {
        super(fm);
        this.data = data;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.ev_tab_layout);
        textView.setText(title[position]);
        return view;
    }
}
