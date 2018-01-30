package com.zj.bilibili.mvp.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.zj.bilibili.R
import com.zj.bilibili.mvp.ui.base.BaseSupportActivity
import com.zj.bilibili.mvp.ui.fragment.main.MainHomeFragment
import com.zj.bilibili.mvp.ui.fragment.main.TestHomeFragment
import me.yokeyword.fragmentation.ISupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:36$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = "/app/main")
class MainActivity : BaseSupportActivity<IPresenter>() {
    private val mFragments = arrayOfNulls<ISupportFragment>(4);

    override fun post(runnable: Runnable?) {
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        initFragmentation()
    }

    private fun initFragmentation() {
        if (findFragment(MainHomeFragment::class.java) == null) {
            mFragments[0] = MainHomeFragment.newInstance()
            mFragments[1] = TestHomeFragment.newInstance()
            mFragments[2] = MainHomeFragment.newInstance()
            mFragments[3] = MainHomeFragment.newInstance()
            loadMultipleRootFragment(R.id.fl_container, 0, *mFragments)
        } else {
            mFragments[0] = findFragment(MainHomeFragment::class.java)
            mFragments[1] = findFragment(TestHomeFragment::class.java)
            mFragments[2] = findFragment(TestHomeFragment::class.java)
            mFragments[3] = findFragment(TestHomeFragment::class.java)
        }
    }
}
