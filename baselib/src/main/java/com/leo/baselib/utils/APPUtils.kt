package com.leo.baselib.utils

import android.content.Context

object APPUtils {
    /**
     * 获取包名
     */
    fun getPackageName(context: Context):String{
        return context.packageName
    }

    /**
     * 是否是第一次启动应用
     */
    fun isFirstLaunchApp():Boolean{
        val isFirstLaunch = SPUtils.getValue(true, "isFirstLaunch") as Boolean
        SPUtils.setValue(false,"isFirstLaunch")
        return isFirstLaunch
    }

}