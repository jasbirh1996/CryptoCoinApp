package com.android.cryptotracker.data.remote

import com.android.cryptotracker.data.dto.CoinDetailDto
import com.android.cryptotracker.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{id}")
    suspend fun getCoinDetail(@Path( "id")coinId : String):CoinDetailDto
}