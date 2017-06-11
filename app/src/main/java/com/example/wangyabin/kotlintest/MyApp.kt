package com.example.wangyabin.kotlintest

/**
 * Created by wangyabin on 2017/5/21.
 */
import android.app.Application

class MyApp : Application() {
    companion object {
        //定义Application对象
        var instance: Application? = null;

        //获取Application对象的方法
        open fun instance(): Application = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        //实例化对象
        instance = this
    }
    //最后：不要忘记在AndroidManfest.xml中注册该APP
}