package com.seniorzhai.dagger2sample.presenter;

import com.seniorzhai.dagger2sample.model.ApiService;
import com.seniorzhai.dagger2sample.model.Gank;
import com.seniorzhai.dagger2sample.model.GankData;
import com.seniorzhai.dagger2sample.view.imp.IMainView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zhai on 16/5/23.
 */

public class MainActivityPresenter {

    private static final int DAY_OF_MILLISECOND = 24 * 60 * 60 * 1000;
    private Date mCurrentDate;
    List<Gank> mGankList = new ArrayList<>();

    private ApiService api;
    private IMainView mView;

    public MainActivityPresenter(ApiService apiService) {
        this.api = apiService;
    }

    public void attachView(IMainView view) {
        mView = view;
    }

    public void onCreate() {
        getData(new Date(System.currentTimeMillis()));
    }

    private void getData(final Date date) {
        mView.showLoading();
        mCurrentDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        api.getGankData(year, month, day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GankData, GankData.Result>() {
                    @Override
                    public GankData.Result call(GankData gankData) {
                        return gankData.getResults();
                    }
                })
                .map(new Func1<GankData.Result, List<Gank>>() {
                    @Override
                    public List<Gank> call(GankData.Result result) {
                        return addAllResults(result);
                    }
                })
                .subscribe(new Subscriber<List<Gank>>() {
                    @Override
                    public void onCompleted() {
                        // after get data complete, need put off time one day
                        mCurrentDate = new Date(date.getTime() - DAY_OF_MILLISECOND);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Gank> list) {
                        // some day the data will be return empty like sunday, so we need get after day data
                        if (list.isEmpty()) {
                            getData(new Date(date.getTime() - DAY_OF_MILLISECOND));
                        } else {
                            mView.fillData(list);
                            mView.hideLoading();
                        }

                    }
                });
    }

    private List<Gank> addAllResults(GankData.Result results) {
        mGankList.clear();
        if (results.getAndroidList() != null) mGankList.addAll(results.getAndroidList());
        if (results.getIOSList() != null) mGankList.addAll(results.getIOSList());
        if (results.getAppList() != null) mGankList.addAll(results.getAppList());
        if (results.getExpandList() != null) mGankList.addAll(results.getExpandList());
        if (results.getRecommendList() != null) mGankList.addAll(results.getRecommendList());
        if (results.getRestList() != null) mGankList.addAll(results.getRestList());
        // make meizi data is in first position
        if (results.getGirlList() != null) mGankList.addAll(0, results.getGirlList());
        return mGankList;
    }


}