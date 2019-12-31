package com.leo.baselib.baseClass

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val TAG = javaClass.name

    /**
     * 初始化布局文件ID
     */
    abstract fun initLayoutId(): Int

    abstract fun initListener()

    abstract fun initView()

    abstract fun initData()

    lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.context = this
        setContentView(initLayoutId())
        initListener()
        initView()
        initData()
    }

    fun showToast(msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    /**
     * 打印日志
     */
    fun log(msg: String) {
        Log.d(TAG, msg)
    }
}
