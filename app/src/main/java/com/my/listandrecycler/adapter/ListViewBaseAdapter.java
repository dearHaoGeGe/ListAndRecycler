package com.my.listandrecycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.listandrecycler.bean.Hero;
import com.my.listandrecycler.R;

import java.util.ArrayList;

/**
 * Created by dllo on 15/12/29.
 */
public class ListViewBaseAdapter extends BaseAdapter {

    private ArrayList<Hero> datas;
    private Context context;

    public ListViewBaseAdapter(ArrayList<Hero> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size() > 0 && datas != null ?datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return datas.size() > 0 && datas != null ? datas.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_listview,viewGroup,false);
            holder = new ViewHolder();
            holder.iv = (ImageView) view.findViewById(R.id.item_iv);
            holder.tv_name = (TextView) view.findViewById(R.id.item_name_tv);
            holder.tv_sex = (TextView) view.findViewById(R.id.item_sex_tv);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Hero hero = (Hero) getItem(i);
        if(hero != null){
            holder.iv.setImageResource(hero.getImageid());
            holder.tv_name.setText(hero.getName());
            holder.tv_sex.setText(hero.getSex());
        }
        return view;
    }

    private class ViewHolder{
        private ImageView iv;
        private TextView tv_name,tv_sex;
    }

    public void addData(Hero newData,int pos){
        datas.add(pos,newData);
        notifyDataSetChanged();
    }

    public void delData(int pos){
        datas.remove(pos);
        notifyDataSetChanged();
    }
}
