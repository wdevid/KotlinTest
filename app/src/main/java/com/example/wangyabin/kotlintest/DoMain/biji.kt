package com.example.wangyabin.kotlintest.DoMain

/**
 * Created by wangyabin on 2017/5/21.
 */
import java.util.*

class biji(var map: MutableMap<String, Any?>) {
    var _id: String by map
    var name: String by map
    var sex: String by map//种类
    var createtime: String by map
    var xiugaitime: String by map
    var content : String by map
    constructor(name: String, sex: String, createtime: String,
                xiugaitime:String, score: String, teacherId: String,content :String) : this(HashMap()) {
        this.name = name
        this.sex = sex
        this.createtime = createtime;
        this.xiugaitime = xiugaitime;
        this.content = content
    }
}