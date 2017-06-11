package com.example.wangyabin.kotlintest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.wangyabin.kotlintest.fragment.BaseFragment
import com.example.wangyabin.kotlintest.fragment.MyFragment
import com.example.wangyabin.kotlintest.fragment.WriteBijiFragment
import com.example.wangyabin.kotlintest.fragment.BijiFragment
import android.view.ViewGroup



class MainActivity : FragmentActivity(), ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.biji -> mViewPager!!.setCurrentItem(0,false)
            R.id.jilu -> mViewPager!!.setCurrentItem(1,false)
            R.id.wode -> mViewPager!!.setCurrentItem(2,false)
        }
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(p0: Int) {
        when(p0){
            0 -> mRadioGroup!!.check(R.id.biji)
            1 -> mRadioGroup!!.check(R.id.jilu)
            2 -> mRadioGroup!!.check(R.id.wode)
        }
    }

    var mViewPager : ViewPager? = null
    var mRadioGroup :RadioGroup ? = null
    var  mRadioButtons : List<RadioButton> ?= null
    var mFragment : List<BaseFragment> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        mViewPager = findViewById(R.id.viewPager) as ViewPager?
        mRadioGroup = findViewById(R.id.radio_group) as RadioGroup?
        var mBiji : RadioButton= findViewById(R.id.biji) as RadioButton
        var mJilu : RadioButton= findViewById(R.id.jilu) as RadioButton
        var mWode : RadioButton= findViewById(R.id.wode) as RadioButton
        mRadioButtons = listOf(mBiji,mJilu,mWode)
        var mBijiFragment = BijiFragment(this)
        var mMyFragment = MyFragment()
        var mWriteFragment = WriteBijiFragment()
        mFragment = listOf(mBijiFragment,mWriteFragment,mMyFragment)
        mRadioGroup!!.setOnCheckedChangeListener(this)
    }

    private fun initData() {
        mViewPager!!.setAdapter(adpter())
        mViewPager!!.setOnPageChangeListener(this)
    }
    inner class adpter : FragmentPagerAdapter(supportFragmentManager){
        override fun getItem(p0: Int): Fragment {
            return mFragment!!.get(p0)
        }

        override fun getCount(): Int {
            return mFragment!!.size
        }

    }

    override fun finish() {
        val view = window.decorView as ViewGroup
        view.removeAllViews()
        super.finish()
    }
}
