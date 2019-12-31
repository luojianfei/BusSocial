package com.bus.social.screen.adapter

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.bus.social.R
import com.bus.social.databinding.ItemAppLayoutBinding
import com.bus.social.entity.AppInfo


class AppListAdapter : BaseAdapter {
    private var context: Context

    private var dataInfos: MutableList<AppInfo>

    constructor(context: Context, dataInfos: MutableList<AppInfo>) {
        this.context = context
        this.dataInfos = dataInfos
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var holder:ViewHolder
        if (view == null) {
            view = View.inflate(context, R.layout.item_app_layout, null)
            view.tag = ViewHolder(view)
        }
        holder = view?.tag as ViewHolder
        holder.setData(position)
        return view
    }

    override fun getItem(position: Int): Any {
        return dataInfos[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return dataInfos.size
    }

    inner class ViewHolder {
        var itemAppLayoutBinding: ItemAppLayoutBinding
        var view:View

        constructor(view: View) {
            this.view = view
            itemAppLayoutBinding = DataBindingUtil.bind(view)!!
        }

        fun setData(position: Int) {
            itemAppLayoutBinding.tvContent.text = dataInfos[position].appName
            var drawableRes = dataInfos[position].appIcon
//            drawableRes.setBounds(0, 0, defaultIcon.minimumWidth, defaultIcon.minimumHeight)

//            itemAppLayoutBinding.ivIcon
//            view.findViewById<ImageView>(R.id.iv_icon).setImageDrawable(drawableRes)
            itemAppLayoutBinding.ivIcon.setImageDrawable(drawableRes)
//            itemAppLayoutBinding.tvContent.setCompoundDrawables(null,drawableRes,null,null)
        }
    }
}