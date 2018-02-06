package com.zj.bilibili.mvp.presenter

import android.app.Application
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import com.zj.bilibili.mvp.contract.LiveContract
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

/**
 * Created by zhengjiong
 * date: 2018/2/6 21:27
 */
class LivePresenter @Inject constructor(
        model: LiveContract.Model,
        view: LiveContract.View,
        private val errorHandler: RxErrorHandler,
        private val application: Application,
        private val appManager: AppManager) : BasePresenter<LiveContract.Model, LiveContract.View>(model, view) {

    fun refresh() {
        //mModel.getLiveData()
    }
}