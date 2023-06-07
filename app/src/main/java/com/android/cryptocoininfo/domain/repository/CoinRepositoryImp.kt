package com.android.cryptocoininfo.domain.repository

import com.android.cryptocoininfo.data.dto.CoinDetailDto
import com.android.cryptocoininfo.data.dto.CoinDto
import com.android.cryptocoininfo.domain.model.Coin

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(id : String): CoinDetailDto
}