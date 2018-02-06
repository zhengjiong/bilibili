package com.zj.bilibili.mvp.ui.fragment.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.flyco.tablayout.SlidingTabLayout
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.zj.bilibili.R
import com.zj.bilibili.mvp.ui.adapter.MainHomeFragmentAdapter
import com.zj.bilibili.mvp.ui.base.BaseSupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:17$
 * @author 郑炯
 * @version 1.0
 */
class MainHomeFragment : BaseSupportFragment<IPresenter>() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.tab_layout)
    lateinit var tabLayout: SlidingTabLayout

    @BindView(R.id.viewpager)
    lateinit var viewPager: ViewPager

    companion object {
        @JvmStatic
        fun newInstance(): MainHomeFragment {
            return MainHomeFragment()
        }
    }

    override fun setData(data: Any?) {

    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.menu.clear()
        toolbar.inflateMenu(R.menu.main_home_menu)
        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item!!.itemId) {
                    R.id.main_active -> {

                    }
                    R.id.main_game -> {

                    }
                    R.id.main_download -> {

                    }
                    R.id.main_search -> {

                    }
                }
                return false
            }
        })

        viewPager.adapter = MainHomeFragmentAdapter(childFragmentManager)
        tabLayout.setViewPager(viewPager)
    }

    override fun post(runnable: Runnable?) {
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // 要让Fragment中的onCreateOptionsMenu()被回调，必须调用setHasOptionsMenu(true);
        //setHasOptionsMenu(true)

        val view = inflater!!.inflate(R.layout.fragment_main_home, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {
    }

}