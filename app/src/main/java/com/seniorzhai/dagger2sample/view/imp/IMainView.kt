package com.seniorzhai.dagger2sample.view.imp

import android.widget.ImageView
import com.seniorzhai.dagger2sample.model.Gank

/**
 * Created by zhai on 16/5/23.
 */

interface IMainView {

    // 显示Loading
    fun showLoading()

    // 隐藏Loading
    fun hideLoading()

    // 渲染数据
    fun fillData(list: List<Gank>)
}
