package com.seniorzhai.dagger2sample.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.seniorzhai.dagger2sample.R;
import com.seniorzhai.dagger2sample.model.Gank;
import com.seniorzhai.dagger2sample.presenter.MainActivityPresenter;
import com.seniorzhai.dagger2sample.reject.components.AppComponent;
import com.seniorzhai.dagger2sample.reject.components.DaggerMainActivityComponent;
import com.seniorzhai.dagger2sample.reject.module.MainActivityModule;
import com.seniorzhai.dagger2sample.view.base.BaseActivity;
import com.seniorzhai.dagger2sample.view.imp.IMainView;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhai on 16/5/23.
 */

public class MainActivity extends BaseActivity implements IMainView {
    @Inject
    MainActivityPresenter presenter;

    @BindView(R.id.iv_image)
    ImageView mIvImage;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitleBar(false,getString(R.string.app_name));
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about:
                new AlertDialog.Builder(this)
                        .setTitle("关于")
                        .setMessage("GankDagger2 一个 MVP + Dagger2 + Retrofit2 组合后的简单 Demo,\n\n项目地址：https://github.com/SeniorZhai/dagger2sample")
                        .setPositiveButton("确定",null)
                        .setNeutralButton("去查看项目", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse("https://github.com/SeniorZhai/dagger2sample");
                                Intent it  = new Intent(Intent.ACTION_VIEW,uri);
                                startActivity(it);
                            }
                        })
                        .show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fillData(List<Gank> list) {
        mTvTitle.setText("今日干货列表");
        for (Gank gank : list) {
            if (gank.is妹子()) {
                Picasso.with(this)
                        .load(gank.url)
                        .noFade()
                        .into(mIvImage);
                mIvImage.setTag(gank);
            } else {
                TextView tv = new TextView(this);
                tv.setText(gank.desc+"( via"+gank.who+")");
                mLlContainer.addView(tv);
            }
        }
    }

    @OnClick(R.id.iv_image)
    public void clickMeizi(){
        MeiziActivity.gotoMeizi(this,(Gank)mIvImage.getTag());
    }

}