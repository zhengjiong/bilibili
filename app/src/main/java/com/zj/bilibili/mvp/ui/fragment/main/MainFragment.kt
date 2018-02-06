package com.zj.bilibili.mvp.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.flyco.tablayout.CommonTabLayout
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.zj.bilibili.R
import com.zj.bilibili.mvp.model.entity.TabEntity
import com.zj.bilibili.mvp.ui.base.BaseSupportFragment
import me.yokeyword.fragmentation.ISupportFragment

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/1/31$  09:19$
 * @author 郑炯
 * @version 1.0
 */
class MainFragment : BaseSupportFragment<IPresenter>() {

    @BindView(R.id.tab_layout)
    lateinit var tabLayout: CommonTabLayout

    private val mFragments = arrayOfNulls<ISupportFragment>(4);

    companion object {
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun setData(data: Any?) {

    }

    override fun initData(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        initBottomTab()
        initFragmentation()
    }

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun setupFragmentComponent(appComponent: AppComponent?) {

    }

    private fun initBottomTab() {
        tabLayout.run {
            setTabData(arrayListOf(
                    TabEntity("首页", R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected),
                    TabEntity("分区", R.mipmap.ic_category_selected, R.mipmap.ic_category_unselected),
                    TabEntity("动态", R.mipmap.ic_dynamic_selected, R.mipmap.ic_dynamic_unselected),
                    TabEntity("消息", R.mipmap.ic_communicate_selected, R.mipmap.ic_communicate_unselected)
            ))
            setOnTabSelectListener(object : com.flyco.tablayout.listener.OnTabSelectListener {
                override fun onTabSelect(position: Int) {
                    /**
                     * show一个Fragment，hide一个Fragment；主要用于类似微信主页那种 切换tab的情况
                     * 同级Fragment场景下的切换
                     */
                    showHideFragment(mFragments[position])
                }

                override fun onTabReselect(position: Int) {

                }
            })
        }
    }

    private fun initFragmentation() {
        if (findChildFragment(MainHomeFragment::class.java) == null) {
            mFragments[0] = MainHomeFragment.newInstance()
            mFragments[1] = TestHomeFragment.newInstance()
            mFragments[2] = TestHomeFragment.newInstance()
            mFragments[3] = TestHomeFragment.newInstance()
            loadMultipleRootFragment(R.id.fl_container, 0, *mFragments)
        } else {
            mFragments[0] = findChildFragment(MainHomeFragment::class.java)
            mFragments[1] = findChildFragment(TestHomeFragment::class.java)
            mFragments[2] = findChildFragment(TestHomeFragment::class.java)
            mFragments[3] = findChildFragment(TestHomeFragment::class.java)
        }
    }
}