package com.android.cryptocoininfo.data.repository

import android.util.Log
import com.android.cryptocoininfo.data.dto.CoinDetailDto
import com.android.cryptocoininfo.data.dto.CoinDto
import com.android.cryptocoininfo.data.remote.CoinPaprikaApi
import com.android.cryptocoininfo.domain.repository.CoinRepository

import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val apiService : CoinPaprikaApi)  :
    CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return  apiService.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
       return apiService.getCoinDetail(id.toString().trim())
    }
}