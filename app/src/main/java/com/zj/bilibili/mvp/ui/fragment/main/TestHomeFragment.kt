package com.zj.bilibili.mvp.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.zj.bilibili.R
import com.zj.bilibili.mvp.ui.base.BaseSupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:36$
 * @author 郑炯
 * @version 1.0
 */
class TestHomeFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance(): TestHomeFragment {
            return TestHomeFragment()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun post(runnable: Runnable?) {
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {
    }

    override fun setData(data: Any?) {
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_main_test, container, false)
    }

}