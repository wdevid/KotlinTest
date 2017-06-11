package com.example.wangyabin.kotlintest.Db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.wangyabin.kotlintest.MyApp
import org.jetbrains.anko.db.*

/**
 * Created by wangyabin on 2017/5/21.
 */
class MyDbHelper(ctx: Context = MyApp.instance()) : ManagedSQLiteOpenHelper(ctx,
        MyDbHelper.DB_NAME, null, 1) {
    companion object {
        val DB_NAME = "biji.db"//数据库名
        val DB_VERSION = 1//版本
        val instance by lazy { MyDbHelper() }
    }

    object Bijiable {
        val T_NAME = "biji"//数据表名称
        val ID = "_id"
        val NAME = "name"
        val SEX = "lei"
        val CONTENT = "content"
        var createtime = "createtime"
        var xiugaitime = "xiugaitime"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(Bijiable.T_NAME, true,
                Bijiable.ID to INTEGER + PRIMARY_KEY,
                Bijiable.NAME to TEXT,
                Bijiable.SEX to TEXT,
                Bijiable.createtime to TEXT,
                Bijiable.xiugaitime to TEXT,
                Bijiable.CONTENT to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


