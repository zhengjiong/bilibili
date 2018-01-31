package com.zj.bilibili.mvp.ui.activity

import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jess.arms.utils.ArmsUtils
import com.zj.bilibili.R
import com.zj.bilibili.mvp.ui.base.BaseSupportActivity
import com.zj.bilibili.mvp.ui.fragment.leftdrawer.HistoryFragment
import com.zj.bilibili.mvp.ui.fragment.main.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_main_drawer.*
import me.yokeyword.fragmentation.ISupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:36
 * @author 郑炯
 * @version 1.0
 */
@Route(path = "/app/main")
class MainActivity : BaseSupportActivity<IPresenter>() {
    var preBackPressTime = 0L

    override fun post(runnable: Runnable?) {
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        initFragment()
        initNavigationView()
    }

    private fun initFragment() {
        loadRootFragment(R.id.fl_container, MainFragment.newInstance())
    }

    private fun initNavigationView() {
        navigationView.setBackgroundColor(ArmsUtils.getColor(this, R.color.nav_menu_bg))
        navigationView.getChildAt(0).isVerticalScrollBarEnabled = false
        navigationView.setCheckedItem(R.id.nav_home)
        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)

            when (item.itemId) {
                R.id.nav_home -> {
                    val mainFragment = findFragment(MainFragment::class.java)
                    if (mainFragment == null) {
                        start(MainFragment.newInstance(), ISupportFragment.SINGLETASK)
                    } else {
                        popTo(MainFragment::class.java, false)
                    }
                }
                R.id.nav_history -> {
                    val historyFragment = findFragment(HistoryFragment::class.java)
                    if (historyFragment == null) {
                        popTo(MainFragment::class.java, false, {
                            start(HistoryFragment.newInstance())
                        })
                    } else {
                        popTo(HistoryFragment::class.java, false)
                    }
                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

    override fun onBackPressedSupport() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
            return
        }
        if (supportFragmentManager.backStackEntryCount > 1) {
            pop()
            if (topFragment !is MainFragment) {
                navigationView.setCheckedItem(R.id.nav_home)
            }
        } else {
            //放置到后台
            //moveTaskToBack(false)


            val now = System.currentTimeMillis()
            if (now - preBackPressTime > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
                preBackPressTime = now
            } else {
                ArmsUtils.exitApp()
            }
        }
    }
}
