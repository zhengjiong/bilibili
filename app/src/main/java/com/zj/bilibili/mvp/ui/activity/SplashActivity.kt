package com.zj.bilibili.mvp.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jess.arms.utils.RxLifecycleUtils
import com.zj.bilibili.R
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

/**
 * Created by zhengjiong
 * date: 2018/1/28 17:47
 */
@Route(path = "/app/splash")
class SplashActivity : BaseActivity<IPresenter>() {
    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_splash
    }

    override fun initData(savedInstanceState: Bundle?) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .compose(RxLifecycleUtils.bindToLifecycle(this))
                .subscribe(Consumer {
                    ARouter.getInstance().build("/app/main").navigation(this)
                })
    }

    override fun setupActivityComponent(appComponent: AppComponent?) {

    }


}