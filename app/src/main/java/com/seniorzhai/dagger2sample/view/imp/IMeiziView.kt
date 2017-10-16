package com.seniorzhai.dagger2sample.view.imp

/**
 * Created by zhai on 16/5/23.
 */

interface IMeiziView {

    fun loadImage(url: String)

    fun onPrepareSave()

    fun onSaveSuccess()

    fun onSaveFail()

    fun onSaveFinish()
}
