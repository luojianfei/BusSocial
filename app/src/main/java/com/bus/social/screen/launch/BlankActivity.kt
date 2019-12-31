package com.bus.social.screen.launch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.leo.baselib.utils.APPUtils

/**
 * 空白页 第一次启动app 跳转WelcomeActivity 非首次启动跳转LaunchActivity
 */
class BlankActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (APPUtils.isFirstLaunchApp()) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        } else {
            startActivity(Intent(this, LaunchActivity::class.java))
        }
        finish()
    }
}