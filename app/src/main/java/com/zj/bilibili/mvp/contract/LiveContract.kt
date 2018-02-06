package com.zj.bilibili.mvp.contract

import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import io.reactivex.Observable

/**
 * Created by zhengjiong
 * date: 2018/2/6 20:57
 */
interface LiveContract {
    interface View : IView {
        //fun setRecyclerViewAdapter(adapter:Adapter)
    }

    interface Model : IModel {
        fun getLiveData(): Observable<List<Any>>
    }
}