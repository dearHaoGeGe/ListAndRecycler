package com.my.listandrecycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.listandrecycler.R;
import com.my.listandrecycler.interfaces.MyClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 15/12/29.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<String> data;
    private List<Integer> Ids;
    private MyClickListener myClickListener;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        initData();
    }

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    private void initData() {
        data = new ArrayList<>();
        Ids = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            data.add("这是第"+i+"条数据");
            Ids.add(R.mipmap.ic_launcher);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));

        if(myClickListener != null){
            //点击
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    myClickListener.onClick(pos);
                }
            });
            //长按
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    myClickListener.onlongClick(pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_tv_recyclerview);
        }
    }

    //添加数据方法
    public void addData(String newData,int pos){
        data.add(pos, newData);
        //notifyDataSetChanged();   //无动画
        notifyItemInserted(pos);    //有动画(Inserted),平滑的感觉(RecyclerView独有的ListView没有)
    }

    //删除数据方法
    public void delData(int pos){
        data.remove(pos);
        notifyItemRemoved(pos);     //有动画Removed
    }
}
