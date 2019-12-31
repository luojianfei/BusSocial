package com.leo.baselib.utils

import android.content.Context
import com.leo.baselib.baseClass.BaseClass

class AppInit : BaseClass() {
    var spName = ""
    var context: Context? = null

    companion object {
        val instance: AppInit by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AppInit()
        }
    }

    /**
     * 初始化
     */
    fun init(initName: String, context: Context) {
        log(initName)
        spName = initName
        this.context = context
    }
}