package com.zj.bilibili.mvp.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zj.bilibili.mvp.ui.fragment.main.home.LiveFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/2/1$  15:47$
 * @author 郑炯
 * @version 1.0
 */

class MainHomeFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragments: ArrayList<Fragment> = arrayListOf(
            LiveFragment.newInstance(),
            LiveFragment.newInstance(),
            LiveFragment.newInstance(),
            LiveFragment.newInstance(),
            LiveFragment.newInstance()
    )
    private val titles: Array<String> = arrayOf(
            "直播",
            "推荐",
            "追番",
            "影视",
            "专栏"
    )

    override fun getItem(position: Int) = fragments.get(position)

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = titles.get(position)
}