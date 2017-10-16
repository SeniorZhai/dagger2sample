package com.seniorzhai.dagger2sample.model

import com.google.gson.annotations.SerializedName

/**
 * Created by zhai on 16/5/23.
 */

class GankData {
    var error: Boolean = false

    var category: List<String>? = null

    var results: Result? = null

    inner class Result {
        @SerializedName("Android")
        var androidList: List<Gank>? = null
        @SerializedName("休息视频")
        var restList: List<Gank>? = null
        @SerializedName("iOS")
        var iOSList: List<Gank>? = null
        @SerializedName("福利")
        var girlList: List<Gank>? = null
        @SerializedName("拓展资源")
        var expandList: List<Gank>? = null
        @SerializedName("瞎推荐")
        var recommendList: List<Gank>? = null
        @SerializedName("App")
        var appList: List<Gank>? = null
    }
}
