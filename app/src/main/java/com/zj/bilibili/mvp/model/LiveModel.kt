package com.zj.bilibili.mvp.model

import com.jess.arms.di.scope.FragmentScope
import com.zj.bilibili.mvp.contract.LiveContract
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zhengjiong
 * date: 2018/2/6 22:09
 */
@FragmentScope
class LiveModel @Inject constructor() : LiveContract.Model {
    override fun getLiveData(): Observable<List<Any>> {
        return Observable.just(listOf())
    }

    override fun onDestroy() {

    }

}