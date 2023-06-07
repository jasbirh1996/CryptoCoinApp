package com.android.cryptocoininfo.common

import android.util.Log
import com.google.gson.Gson
import okhttp3.logging.HttpLoggingInterceptor

class ApiLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("ApiData",message)
    }
}