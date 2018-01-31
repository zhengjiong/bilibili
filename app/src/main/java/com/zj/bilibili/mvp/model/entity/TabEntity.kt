package com.zj.bilibili.mvp.model.entity

import com.flyco.tablayout.listener.CustomTabEntity

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/31$  17:11$
 * @author 郑炯
 * @version 1.0
 */
class TabEntity(private var tabTitle: String, private var tabSelectedIcon: Int, private var tabUnSelectedIcon: Int) : CustomTabEntity {
    override fun getTabSelectedIcon(): Int {
        return tabSelectedIcon
    }

    override fun getTabTitle(): String {
        return tabTitle
    }

    override fun getTabUnselectedIcon(): Int {
        return tabUnSelectedIcon
    }

}