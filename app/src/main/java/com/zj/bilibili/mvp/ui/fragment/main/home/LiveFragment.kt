package com.zj.bilibili.mvp.ui.fragment.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.zj.bilibili.R
import com.zj.bilibili.mvp.presenter.LivePresenter
import com.zj.bilibili.mvp.ui.base.BaseSupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/2/1$  15:43$
 * @author 郑炯
 * @version 1.0
 */

class LiveFragment : BaseSupportFragment<LivePresenter>() {

    companion object {

        @JvmStatic
        fun newInstance(): LiveFragment {
            return LiveFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {

    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_live, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }

}