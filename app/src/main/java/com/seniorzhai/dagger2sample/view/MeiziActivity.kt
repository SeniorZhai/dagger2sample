package com.seniorzhai.dagger2sample.view

/**
 * Created by zhai on 16/5/23.
 */

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.seniorzhai.dagger2sample.R
import com.seniorzhai.dagger2sample.model.Gank
import com.seniorzhai.dagger2sample.presenter.MeiziPresenter
import com.seniorzhai.dagger2sample.reject.components.AppComponent
import com.seniorzhai.dagger2sample.reject.components.DaggerMeiziActivityComponent
import com.seniorzhai.dagger2sample.reject.module.MeiziActivityModule
import com.seniorzhai.dagger2sample.view.base.BaseActivity
import com.seniorzhai.dagger2sample.view.imp.IMeiziView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_meizi.*
import javax.inject.Inject

class MeiziActivity : BaseActivity(), IMeiziView {
    @Inject
    protected lateinit var mPresenter: MeiziPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meizi)
        setTitleBar(true, "妹子")

        mPresenter.attachView(this)
        mPresenter.setContext(this)
        mPresenter.fillData(intent.getSerializableExtra(EXTRA_GANK) as Gank)
        mPresenter.onCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_meizi, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.action_save -> mPresenter.saveMeizi(iv_girl_detail)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMeiziActivityComponent.builder()
                .meiziActivityModule(MeiziActivityModule())
                .build()
                .inject(this)
    }

    override fun onPrepareSave() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun onSaveSuccess() {
        Toast.makeText(this@MeiziActivity, "save successfully ^_^", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveFail() {
        Toast.makeText(this@MeiziActivity, "save fail *_*", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveFinish() {
        pb_loading.visibility = View.GONE
    }

    override fun loadImage(url: String) {
        Picasso.with(this)
                .load(url)
                .noFade()
                .into(iv_girl_detail)
    }

    companion object {
        private val EXTRA_GANK = "GANK"

        fun gotoMeizi(activity: Activity, gank: Gank) {
            val intent = Intent(activity, MeiziActivity::class.java)
            intent.putExtra(EXTRA_GANK, gank)
            activity.startActivity(intent)
        }
    }
}