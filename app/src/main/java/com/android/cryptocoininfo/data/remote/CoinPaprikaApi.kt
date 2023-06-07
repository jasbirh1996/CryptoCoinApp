package com.android.cryptocoininfo.data.remote

import com.android.cryptocoininfo.data.dto.CoinDetailDto
import com.android.cryptocoininfo.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{id}")
    suspend fun getCoinDetail(@Path( "id")coinId : String):CoinDetailDto
}