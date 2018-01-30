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
 * Company: 上加下信息技术成都有限公司
 * CreateTime:18/1/30$  16:17$
 * @author 郑炯
 * @version 1.0
 */
class MainHomeFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        @JvmStatic
        fun newInstance(): MainHomeFragment {
            return MainHomeFragment()
        }
    }

    override fun setData(data: Any?) {

    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun post(runnable: Runnable?) {
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // 要让Fragment中的onCreateOptionsMenu()被回调，必须调用setHasOptionsMenu(true);
        setHasOptionsMenu(true)

        return inflater!!.inflate(R.layout.fragment_main_home, container, false)
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {
    }

}