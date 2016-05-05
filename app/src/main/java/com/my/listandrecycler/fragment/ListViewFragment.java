package com.my.listandrecycler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.my.listandrecycler.bean.Hero;
import com.my.listandrecycler.R;
import com.my.listandrecycler.adapter.ListViewBaseAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 15/12/29.
 */
public class ListViewFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView listView;
    private ListViewBaseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getActivity().findViewById(R.id.fragment_listview);
        ArrayList<Hero> data = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            data.add(new Hero("寒冰",R.mipmap.ic_launcher,"女"));
            data.add(new Hero("小炮",R.mipmap.ic_launcher,"女"));
            data.add(new Hero("泰隆",R.mipmap.ic_launcher,"男"));
        }

        listView.setOnItemClickListener(this);      //点击删除
        listView.setOnItemLongClickListener(this);  //长按删除

        adapter = new ListViewBaseAdapter(data,getActivity());
        listView.setAdapter(adapter);
        getActivity().findViewById(R.id.btn_fragment_listview).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fragment_listview:
                adapter.addData(new Hero("蛮王新加的",R.mipmap.ic_launcher,"男"),0);
                break;
        }
    }

    //点击删除
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        adapter.delData(i);
    }

    //长按删除
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        adapter.delData(i);
        return false;
    }
}
