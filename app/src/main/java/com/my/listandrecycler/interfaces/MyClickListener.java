package com.my.listandrecycler.interfaces;

/**
 * Created by dllo on 15/12/29.
 * 专门为我们的recyclerView写的点击监听接口
 */
public interface MyClickListener {
    void onClick(int position); //点击事件的回调方法
    void onlongClick(int position); //长按
}
