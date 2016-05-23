package com.seniorzhai.dagger2sample.reject.components;

import com.seniorzhai.dagger2sample.ActivityScope;
import com.seniorzhai.dagger2sample.reject.module.MainActivityModule;
import com.seniorzhai.dagger2sample.view.MainActivity;

import dagger.Component;

/**
 * Created by zhai on 16/5/23.
 */
@ActivityScope
@Component(modules = MainActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}