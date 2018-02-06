package com.zj.bilibili.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.zj.bilibili.di.module.LiveModule
import com.zj.bilibili.mvp.ui.fragment.main.home.LiveFragment
import dagger.Component

/**
 * Created by zhengjiong
 * date: 2018/2/6 20:54
 */
@FragmentScope
@Component(modules = arrayOf(LiveModule::class), dependencies = arrayOf(AppComponent::class))
interface LiveComponent {
    fun inject(fragment: LiveFragment)
}
