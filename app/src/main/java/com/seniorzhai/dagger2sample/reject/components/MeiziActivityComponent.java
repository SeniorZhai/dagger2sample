package com.seniorzhai.dagger2sample.reject.components;

import com.seniorzhai.dagger2sample.ActivityScope;
import com.seniorzhai.dagger2sample.reject.module.MeiziActivityModule;
import com.seniorzhai.dagger2sample.view.MeiziActivity;

import dagger.Component;

/**
 * Created by zhai on 16/5/23.
 */
@ActivityScope
@Component(modules = MeiziActivityModule.class)
public interface MeiziActivityComponent {
    MeiziActivity inject(MeiziActivity meiziActivity);
}
