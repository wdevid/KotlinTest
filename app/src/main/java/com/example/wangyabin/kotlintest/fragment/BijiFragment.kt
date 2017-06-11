package com.example.wangyabin.kotlintest.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wangyabin.kotlintest.Dao.daobiji
import com.example.wangyabin.kotlintest.MainActivity
import com.example.wangyabin.kotlintest.MyApp
import com.example.wangyabin.kotlintest.R
import com.example.wangyabin.kotlintest.adapter.MyAdapter

/**
 * Created by wangyabin on 2017/5/21.
 */
class BijiFragment(fm: MainActivity) : BaseFragment() {
    var mView: View? = null
    var mRecyclerView: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            if (inflater != null) {
                mView = inflater.inflate(R.layout.pager1, null)
            }
        }
        initView()
        initData()
        return mView
    }


    override fun initView() {
        if (mView != null && mRecyclerView == null) {
            mRecyclerView = (mView as View).findViewById(R.id.lv) as RecyclerView?
        }
    }

    override fun initData() {
        var db : daobiji = daobiji(MyApp.instance())
        mRecyclerView!!.adapter = MyAdapter(db.selectAll());
    }

}