package com.seniorzhai.dagger2sample.view.imp;

import android.widget.ImageView;

/**
 * Created by zhai on 16/5/23.
 */

public interface IMeiziView {

    ImageView getImageView();

    void onPrepareSave();

    void onSaveSuccess();

    void onSaveFail();

    void onSaveFinish();
}
