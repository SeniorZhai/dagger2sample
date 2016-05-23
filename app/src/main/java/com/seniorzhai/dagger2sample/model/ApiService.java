package com.seniorzhai.dagger2sample.model;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zhai on 16/5/23.
 */

public interface ApiService {
    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month, @Path("day") int day);
}
