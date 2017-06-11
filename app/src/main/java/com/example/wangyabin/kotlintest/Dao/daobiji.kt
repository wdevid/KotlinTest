package com.example.wangyabin.kotlintest.Dao

import android.content.ContentValues
import android.content.Context
import com.example.wangyabin.kotlintest.MyApp
import com.example.wangyabin.kotlintest.Db.MyDbHelper
import com.example.wangyabin.kotlintest.DoMain.biji
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.update

/**
 * Created by wangyabin on 2017/5/21.
 */
class daobiji(ctx:  Context = MyApp.instance()) {
    var db : MyDbHelper = MyDbHelper.instance
    /**
     * 根据id查询所有
     */
    open fun selectAll() :List<biji>{
        return db.writableDatabase.select(MyDbHelper.Bijiable.T_NAME).parseList{biji(HashMap(it))}
    }
    /**
     * 增加
     */
    open fun add(name: String, content: String, leixing: String,createtime:String,xiugaitime:String){
        var values: ContentValues? = null
        values?.put(MyDbHelper.Bijiable.NAME,name)
        values?.put(MyDbHelper.Bijiable.CONTENT,content)
        values?.put(MyDbHelper.Bijiable.SEX,leixing)
        values?.put(MyDbHelper.Bijiable.createtime,createtime)
        values?.put(MyDbHelper.Bijiable.xiugaitime,xiugaitime)
        db.writableDatabase.insert(MyDbHelper.Bijiable.T_NAME,null,values)
    }

    /**
     * 根据id更新数据库
     */
    open fun update(id : Int,name: String, content: String, leixing: String,createtime:String,xiugaitime:String){
        var dailyRequest = MyDbHelper.Bijiable.ID + " ="
        var dir = arrayOf("$id")
        var values: ContentValues? = null
        values?.put(MyDbHelper.Bijiable.NAME, name)
        values?.put(MyDbHelper.Bijiable.CONTENT, content)
        values?.put(MyDbHelper.Bijiable.createtime, createtime)
        values?.put(MyDbHelper.Bijiable.xiugaitime, xiugaitime)
        values?.put(MyDbHelper.Bijiable.SEX, leixing)
        db.writableDatabase.update(MyDbHelper.Bijiable.T_NAME, values, dailyRequest, dir);
    }

    /**
     * 根据id删除
     */
    open fun delete(id:Int){
        var dailyRequest = MyDbHelper.Bijiable.ID + " ="
        var dir = arrayOf("$id")
        db.writableDatabase.delete(MyDbHelper.Bijiable.T_NAME, dailyRequest, dir)
    }
    //返回数据集合
    fun <T : Any> SelectQueryBuilder.parseList(
            parser: (Map<String, Any>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T {
                    return parser(columns as Map<String, Any>)
                }
            })

    //返回可以为null对象，parseSingle效果一样，但是返回不能为null
    fun <T : Any> SelectQueryBuilder.parseOpt(
            parser: (Map<String, Any>) -> T): T? =
            parseOpt(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T {
                    return parser(columns as Map<String, Any>)
                }
            })
}