package com.seniorzhai.dagger2sample.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.seniorzhai.dagger2sample.R
import com.seniorzhai.dagger2sample.model.Gank
import com.seniorzhai.dagger2sample.presenter.MainActivityPresenter
import com.seniorzhai.dagger2sample.reject.components.AppComponent
import com.seniorzhai.dagger2sample.reject.components.DaggerMainActivityComponent
import com.seniorzhai.dagger2sample.reject.module.MainActivityModule
import com.seniorzhai.dagger2sample.view.base.BaseActivity
import com.seniorzhai.dagger2sample.view.imp.IMainView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by zhai on 16/5/23.
 */

class MainActivity : BaseActivity(), IMainView {

    @Inject
    protected lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleBar(false, getString(R.string.app_name))
        presenter.attachView(this)
        presenter.onCreate()
        iv_image.setOnClickListener({ MeiziActivity.gotoMeizi(this, iv_image.tag as Gank) })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> AlertDialog.Builder(this)
                    .setTitle("关于")
                    .setMessage("GankDagger2 一个 MVP + Dagger2 + Retrofit2 组合后的简单 Demo,\n\n项目地址：https://github.com/SeniorZhai/dagger2sample")
                    .setPositiveButton("确定", null)
                    .setNeutralButton("去查看项目") { _, _ ->
                        val uri = Uri.parse("https://github.com/SeniorZhai/dagger2sample")
                        val it = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(it)
                    }
                    .show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(MainActivityModule())
                .build()
                .inject(this)
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.INVISIBLE
    }

    override fun fillData(list: List<Gank>) {
        tv_title.text = "今日干货列表"
        for (gank in list) {
            if (gank.is妹子) {
                Picasso.with(this)
                        .load(gank.url)
                        .noFade()
                        .into(iv_image)
                iv_image.tag = gank
            } else {
                val tv = TextView(this)
                tv.text = (gank.desc + "( via " + gank.who + ")")
                ll_container.addView(tv)
            }
        }
    }

}