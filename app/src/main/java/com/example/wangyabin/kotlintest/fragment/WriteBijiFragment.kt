package com.example.wangyabin.kotlintest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.wangyabin.kotlintest.Dao.daobiji
import com.example.wangyabin.kotlintest.R
import com.example.wangyabin.kotlintest.utils.ExchangerData

/**
 * Created by wangyabin on 2017/5/21.
 */
class WriteBijiFragment : BaseFragment(),View.OnClickListener{
    override fun inData(message: Any) {

    }

    override fun inClick(view: View, type: Int) {

    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.btn_save ->{
                Log.e("aadd","addd");
                content = editView!!.text.toString().trim()
                name = editName!!.text.toString().trim()
                db!!.add(name!!,content!!,"biji",System.currentTimeMillis().toString()
                        ,System.currentTimeMillis().toString())
                var Tag : String = "add"
                exchaner.exchange(Tag,BaseFragment.javaClass)


            }
        }

    }
    var writeView : View ?=null
    var editView : EditText? = null
    var editName : EditText? = null
    var save :Button? = null
    var content :String? = null
    var name :String? = null
    var db : daobiji? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        writeView  = inflater!!.inflate(R.layout.write_fragment,null);
        return writeView
    }

    override fun initView() {
        editView = writeView!!.findViewById(R.id.edit) as EditText
        editName = writeView!!.findViewById(R.id.name) as EditText
        save = writeView!!.findViewById(R.id.btn_save) as Button?
    }

    override fun initData() {
        save!!.setOnClickListener(this)
    }
}