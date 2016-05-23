package com.seniorzhai.dagger2sample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhai on 16/5/23.
 */

public class GankData {
    public boolean error;

    public List<String> category;

    public Result results;

    public class Result {
        @SerializedName("Android")
        public List<Gank> androidList;
        @SerializedName("休息视频")
        public List<Gank> restList;
        @SerializedName("iOS")
        public List<Gank> iOSList;
        @SerializedName("福利")
        public List<Gank> girlList;
        @SerializedName("拓展资源")
        public List<Gank> expandList;
        @SerializedName("瞎推荐")
        public List<Gank> recommendList;
        @SerializedName("App")
        public List<Gank> appList;
    }
}
