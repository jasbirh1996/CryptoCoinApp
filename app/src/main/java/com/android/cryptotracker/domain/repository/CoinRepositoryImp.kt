package com.android.cryptotracker.domain.repository

import com.android.cryptotracker.data.dto.CoinDetailDto
import com.android.cryptotracker.data.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(id : String): CoinDetailDto
}