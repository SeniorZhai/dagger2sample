package com.seniorzhai.dagger2sample.model

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by zhai on 16/5/23.
 */

interface ApiService {
    @GET("day/{year}/{month}/{day}")
    fun getGankData(@Path("year") year: Int, @Path("month") month: Int, @Path("day") day: Int): Observable<GankData>
}