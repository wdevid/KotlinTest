package com.example.wangyabin.kotlintest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wangyabin.kotlintest.utils.ExchangerData

/**
 * Created by wangyabin on 2017/5/21.
 */
class MyFragment : BaseFragment(),ExchangerData.OnDataExchangeListener{
    override fun inData(message: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inClick(view: View, type: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {
    }

    override fun initData() {

    }
}