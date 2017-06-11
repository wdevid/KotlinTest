package com.example.wangyabin.kotlintest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.wangyabin.kotlintest.Dao.daobiji
import com.example.wangyabin.kotlintest.R

/**
 * Created by wangyabin on 2017/5/21.
 */
class WriteBijiFragment : BaseFragment(),View.OnClickListener{
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_save ->{
                if (editView!!.text.length>=0&&editName!!.text.length>=0){
                    content = editView!!.text.toString().trim()
                    name = editName!!.text.toString().trim()
                    db!!.add(name!!,content!!,"biji",System.currentTimeMillis().toString()
                            ,System.currentTimeMillis().toString())
                }

            }


        }
    }
    var editView : EditText? = null
    var editName : EditText? = null
    var content :String? = null
    var name :String? = null
    var db : daobiji? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var writeView : View = inflater!!.inflate(R.layout.write_fragment,null);

        editView = writeView.findViewById(R.id.edit) as EditText
        editName = writeView.findViewById(R.id.name) as EditText
        return writeView
    }

    override fun initView() {
    }

    override fun initData() {

    }
}