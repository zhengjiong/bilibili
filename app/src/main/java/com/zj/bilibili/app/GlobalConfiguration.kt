package com.zj.bilibili.app

import android.app.Application
import android.content.Context
import android.support.v4.app.FragmentManager
import com.jess.arms.base.delegate.AppLifecycles
import com.jess.arms.di.module.GlobalConfigModule
import com.jess.arms.integration.ConfigModule
import com.zj.bilibili.app.config.lifecyclesoptions.MyActivityLifecycle
import com.zj.bilibili.app.config.lifecyclesoptions.MyAppLifecycles

/**
 * Created by zhengjiong
 * date: 2018/1/28 17:57
 */
class GlobalConfiguration() : ConfigModule {
    override fun injectFragmentLifecycle(context: Context?, lifecycles: MutableList<FragmentManager.FragmentLifecycleCallbacks>?) {
        //向Fragment的生命周期中注入一些自定义逻辑
    }

    override fun applyOptions(context: Context?, builder: GlobalConfigModule.Builder?) {
        //使用builder可以为框架配置一些配置信息
        /*builder
                //.baseurl(Api.APP_DOMAIN)
                .retrofitConfiguration(MyRetrofitConfiguration())
                // 使用统一UserAgent
                //                .addInterceptor(new UserAgentInterceptor())
                .rxCacheConfiguration(MyRxCacheConfiguration())
                .globalHttpHandler(MyGlobalHttpHandler())
                .responseErrorListener(MyResponseErrorListener())
                .cacheFile(File(DataHelper.getCacheFile(context), "rxCache"))
                .gsonConfiguration(MyGsonConfiguration())*/
    }

    override fun injectAppLifecycle(context: Context?, lifecycles: MutableList<AppLifecycles>?) {
        //向Application的生命周期中注入一些自定义逻辑
        lifecycles!!.add(MyAppLifecycles())
    }

    override fun injectActivityLifecycle(context: Context?, lifecycles: MutableList<Application.ActivityLifecycleCallbacks>?) {
        //向Activity的生命周期中注入一些自定义逻辑
        lifecycles!!.add(MyActivityLifecycle())
    }

}