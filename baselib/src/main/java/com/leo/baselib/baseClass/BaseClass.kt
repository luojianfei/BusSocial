package com.leo.baselib.baseClass

import android.util.Log

open class BaseClass {
    val TAG = javaClass.name

    /**
     * 打印日志
     */
    fun log(msg: String) {
        Log.d(TAG, msg)
    }

}