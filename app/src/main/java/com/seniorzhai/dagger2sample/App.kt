package com.seniorzhai.dagger2sample

import android.app.Application
import android.content.Context
import com.luseen.logger.LogType
import com.luseen.logger.Logger
import com.seniorzhai.dagger2sample.reject.components.AppComponent
import com.seniorzhai.dagger2sample.reject.components.DaggerAppComponent
import com.seniorzhai.dagger2sample.reject.module.ApiServiceModule
import com.squareup.leakcanary.LeakCanary

/**
 * Created by zhai on 16/5/23.
 */

class App : Application() {
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        // 注入AppModule ApiServiceModule
        appComponent = DaggerAppComponent.builder()
                .apiServiceModule(ApiServiceModule())
                .build()
        if (LeakCanary.isInAnalyzerProcess(this))
            return
        LeakCanary.install(this)
        Logger.Builder()
                .isLoggable(BuildConfig.DEBUG)
                .logType(LogType.ERROR)
                .tag("Logger")
                .setIsKotlin(true)
                .build()
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}
