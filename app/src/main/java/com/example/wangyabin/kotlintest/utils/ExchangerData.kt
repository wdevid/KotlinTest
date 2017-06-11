package com.example.wangyabin.kotlintest.utils

import java.util.Vector

import android.view.View

/**
 * Created by wangyabin on 2017/5/21.
 */
open class ExchangerData {

    private val container = Vector<OnDataExchangeListener>()

    fun add(listener: OnDataExchangeListener) {
        container.add(listener)
    }

    fun remove(listener: OnDataExchangeListener) {
        container.remove(listener)
    }

   open fun exchange(message: String, c: Class<*>) {
        val i = `in`(c)
        if (i > -1) {
            container[i].inData(message)
        }
    }

    fun click(view: View, type: Int, c: Class<*>) {
        val i = `in`(c)
        if (i > -1) {
            container[i].inClick(view, type)
        }
    }

    private fun `in`(c: Class<*>): Int {
        for (i in container.indices) {
            if (container[i].javaClass == c) {
                return i
            }
        }
        return -1
    }

    interface OnDataExchangeListener {
        fun inData(message: Any)

        fun inClick(view: View, type: Int)
    }

}
