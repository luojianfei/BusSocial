package com.bus.social.screen.launch

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.widget.Toast
import com.bus.social.R
import com.bus.social.entity.AppInfo
import com.bus.social.screen.adapter.AppListAdapter
import com.leo.baselib.baseClass.BaseActivity
import kotlinx.android.synthetic.main.activity_launch.*



class LaunchActivity : BaseActivity() {

    private var dataInfos: MutableList<AppInfo> = ArrayList()
    override fun initLayoutId(): Int {
        return R.layout.activity_launch
    }

    override fun initListener() {
        btn_open_others.setOnClickListener {

        }
    }

    override fun initView() {

    }

    override fun initData() {
        getPackages()
    }

    private fun getPackages() {
        // 获取已经安装的所有应用, PackageInfo　系统类，包含应用信息
        var packages: MutableList<PackageInfo> = packageManager.getInstalledPackages(0)
        for (index in 0 until packages.size) {
            var packageInfo: PackageInfo = packages[index]
            if (packageInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM === 0) {
                //系统应用
                dataInfos.add(
                    AppInfo(
                        packageInfo.applicationInfo.loadLabel(packageManager).toString(),
                        packageInfo.packageName,
                        packageInfo.applicationInfo.loadIcon(packageManager)
                    )
                )
            } else {
//                dataInfos.add(
//                    AppInfo(
//                        packageInfo.applicationInfo.loadLabel(packageManager).toString(),
//                        packageInfo.packageName,
//                        packageInfo.applicationInfo.loadIcon(packageManager)
//                    )
//                )
            }
        }
        val adapter = AppListAdapter(context, dataInfos)
        gv_app.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}