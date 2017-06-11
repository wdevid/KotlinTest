package com.example.wangyabin.kotlintest.adapter

import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import com.example.wangyabin.kotlintest.DoMain.biji

/**
 * Created by wangyabin on 2017/5/22.
 */
public class MyAdapter(val items: List<biji>) :RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    //创建ViewHodler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    //绑定ViewHolder并设置数据
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].content
    }

    //实现getItemCount，处理数据的条目数量
    override fun getItemCount(): Int = items.size;

    //定义ViewHolder，现在只需要一个	TextView
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView);
}