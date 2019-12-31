package com.bus.social.screen.launch

import android.app.Activity
import android.os.Bundle
import com.bus.social.R

class WelcomeActivity :Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
}