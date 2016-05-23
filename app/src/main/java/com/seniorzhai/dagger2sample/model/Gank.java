package com.seniorzhai.dagger2sample.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhai on 16/5/23.
 */

public class Gank implements Serializable {
    protected long id;
    public String objectId;

    public boolean used;
    public String type;
    public String url;
    public String who;
    public String desc;
    public Date updatedAt;
    public Date createdAt;
    public Date publishedAt;

    public boolean is妹子() {
        return "福利".equals(type);
    }

    @Override
    public Gank clone() {
        Gank gank = null;
        try {
            gank = (Gank) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return gank;
    }
}
