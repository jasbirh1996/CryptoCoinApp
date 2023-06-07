package com.android.cryptotracker.common

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class ApiLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("ApiData",message)
    }
}