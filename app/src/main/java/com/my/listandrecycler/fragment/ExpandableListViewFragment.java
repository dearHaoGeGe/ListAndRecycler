package com.my.listandrecycler.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.my.listandrecycler.R;
import com.my.listandrecycler.adapter.MyBaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 15/12/29.
 */
public class ExpandableListViewFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private ExpandableListView listView;
    private MyBaseExpandableListAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expandablelistview,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ExpandableListView) getActivity().findViewById(R.id.fragment_expandedlistview);

        adapter = new MyBaseExpandableListAdapter(context);
        listView.setAdapter(adapter);

        getActivity().findViewById(R.id.btn_fragment_expandlistview).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fragment_expandlistview:

                break;
        }
    }
}
