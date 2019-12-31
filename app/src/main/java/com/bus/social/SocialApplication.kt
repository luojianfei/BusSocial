package com.bus.social

import android.app.Application
import com.leo.baselib.utils.APPUtils
import com.leo.baselib.utils.AppInit

class SocialApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        AppInit.instance.init(APPUtils.getPackageName(applicationContext),applicationContext)
    }
}