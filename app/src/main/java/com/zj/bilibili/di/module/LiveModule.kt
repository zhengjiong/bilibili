package com.zj.bilibili.di.module

import com.jess.arms.di.scope.FragmentScope
import com.zj.bilibili.mvp.contract.LiveContract
import com.zj.bilibili.mvp.model.LiveModel
import dagger.Module
import dagger.Provides

/**
 * Created by zhengjiong
 * date: 2018/2/6 20:55
 */
@Module
class LiveModule(val view: LiveContract.View) {

    @FragmentScope
    @Provides
    fun provideView(): LiveContract.View {
        return view
    }

    //这样可以编译通过
    /*@FragmentScope
    @Provides
    fun provideLiveModel(): LiveContract.Model {
        return LiveModel()
    }*/

    /**
     * 编译失败, 因为LivePresenter的构造使用的是LiveContract.Model接口,
     * 所以这里不能返回其实现类,除非构造方法也改为LiveModel !
     */
    /*@FragmentScope
    @Provides
    fun provideLiveModel(): LiveModel {
        return LiveModel()
    }*/

    /**
     * 编译失败, 因为LivePresenter的构造使用的是LiveContract.Model接口
     */
    /*@FragmentScope
    @Provides
    fun provideLiveModel(model: LiveModel): LiveModel {
        return model
    }*/

    @FragmentScope
    @Provides
    fun provideLiveModel(model: LiveModel): LiveContract.Model {
        return model
    }
}