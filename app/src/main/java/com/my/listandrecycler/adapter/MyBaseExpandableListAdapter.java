package com.my.listandrecycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.my.listandrecycler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 15/12/29.
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private List<String> group;
    private List<List<String>> child;
    private Context context;

    public MyBaseExpandableListAdapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        group = new ArrayList<>();
        child = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            group.add("这是第" + i + "个分组");
            List<String> subChild = new ArrayList<>();
            for (int j = 1; j < 20; j++) {
                subChild.add("这是第" + i + "个分组的第" + j + "项");
            }
            child.add(subChild);
        }
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return group.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_group_expandablelistview, viewGroup, false);
            groupViewHolder = new GroupViewHolder(view);
            view.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        groupViewHolder.textView.setText(group.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildGroupViewHolder childGroupViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_child_expandablelistview, viewGroup, false);
            childGroupViewHolder = new ChildGroupViewHolder(view);
            view.setTag(childGroupViewHolder);
        } else {
            childGroupViewHolder = (ChildGroupViewHolder) view.getTag();
        }
        childGroupViewHolder.textView.setText(child.get(i).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupViewHolder {
        TextView textView;

        public GroupViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv_item_group_expandablelistview);
        }
    }

    class ChildGroupViewHolder {
        TextView textView;

        public ChildGroupViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv_item_child_expandablelistview);
        }
    }

    //group添加数据
    public void addData(String newData, int group, int childPos) {
        child.get(group).add(childPos, newData);
        notifyDataSetChanged();
    }

    //child添加数据
    public void addData(String groupName, String childData, int groupPos) {
        //新的这一组加到groupPos的位置,组名是groupName
        group.add(groupPos, groupName);
        //为这新的一组,创建一个新的集合,装着child的数据
        List<String> newChild = new ArrayList<>();
        //向这个新的集合里添加数据(childData)
        newChild.add(childData);
        //将这个新的集合,加到指定的组的位置
        child.add(groupPos, newChild);
        //通知适配器,刷新数据
        notifyDataSetChanged();
    }
}
