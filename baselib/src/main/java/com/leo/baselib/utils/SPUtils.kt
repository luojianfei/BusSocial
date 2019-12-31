package com.leo.baselib.utils

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.leo.baselib.utils.AppInit.Companion.instance

object SPUtils {
    private val preferences: SharedPreferences? =
        instance.context?.getSharedPreferences(instance.spName, MODE_PRIVATE)

    fun getValue(defaultValue: Any = "Default", key: String): Any? {
        return when (defaultValue) {
            is String -> preferences?.getString(
                key,
                defaultValue
            ) ?: ""
            is Int -> preferences?.getInt(
                key,
                defaultValue
            ) ?: 0
            is Boolean -> preferences?.getBoolean(
                key,
                defaultValue
            ) ?: false
            is Float -> preferences?.getFloat(
                key,
                defaultValue
            ) ?: 0F
            is Long -> preferences?.getLong(
                key,
                defaultValue
            ) ?: 0L
            else -> null
        }
    }

    fun setValue(value: Any, key: String) {
        when (value) {
            is String -> preferences?.edit()?.putString(
                key,
                value
            )?.apply()
            is Int -> preferences?.edit()?.putInt(
                key,
                value
            )?.apply()
            is Boolean -> preferences?.edit()?.putBoolean(
                key,
                value
            )?.apply()
            is Float -> preferences?.edit()?.putFloat(
                key,
                value
            )?.apply()
            is Long -> preferences?.edit()?.putLong(
                key,
                value
            )?.apply()
        }
    }
}