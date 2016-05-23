package com.seniorzhai.dagger2sample.view.imp;

import com.seniorzhai.dagger2sample.model.Gank;

import java.util.List;

/**
 * Created by zhai on 16/5/23.
 */

public interface IMainView {
    // 显示Loading
    void showLoading();
    // 隐藏Loading
    void hideLoading();
    // 渲染数据
    void fillData(List<Gank> list);
}
