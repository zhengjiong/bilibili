package com.zj.bilibili.app

import android.content.Context
import android.support.multidex.MultiDex
import com.jess.arms.base.BaseApplication

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/30$  16:14$
 * @author 郑炯
 * @version 1.0
 */
class App : BaseApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}