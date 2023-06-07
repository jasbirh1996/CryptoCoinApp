package com.android.cryptotracker.data.repository

import com.android.cryptotracker.data.dto.CoinDetailDto
import com.android.cryptotracker.data.dto.CoinDto
import com.android.cryptotracker.data.remote.CoinPaprikaApi
import com.android.cryptotracker.domain.repository.CoinRepository

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