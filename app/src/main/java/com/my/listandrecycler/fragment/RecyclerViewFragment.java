package com.my.listandrecycler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.listandrecycler.R;
import com.my.listandrecycler.adapter.RecyclerViewAdapter;
import com.my.listandrecycler.interfaces.MyClickListener;
import com.my.listandrecycler.line.DividerGridItemDecoration;
import com.my.listandrecycler.line.DividerItemDecoration;

/**
 * Created by dllo on 15/12/29.
 */
public class RecyclerViewFragment extends Fragment implements View.OnClickListener,MyClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_fragment_recyclerview);

        adapter = new RecyclerViewAdapter(getActivity());

        adapter.setMyClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(adapter);

        getActivity().findViewById(R.id.btn_fragment_recyclerview).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fragment_recyclerview:
                adapter.addData("这是新的数据",1);
                break;
        }
    }

    @Override
    public void onClick(int position) {
        adapter.delData(position);
    }

    @Override
    public void onlongClick(int position) {
        adapter.delData(position);
    }
}
