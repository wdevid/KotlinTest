package com.example.wangyabin.kotlintest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wangyabin.kotlintest.utils.ExchangerData

/**
 * Created by wangyabin on 2017/5/21.
 */
open class BaseFragment : Fragment(), ExchangerData.OnDataExchangeListener{
    companion object {
        var exchaner : ExchangerData= ExchangerData()
    }
    override fun inData(message: Any) {
    }

    override fun inClick(view: View, type: Int) {
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()
        initData()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    open fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}