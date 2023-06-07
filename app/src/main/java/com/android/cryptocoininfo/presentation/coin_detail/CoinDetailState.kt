package com.android.cryptocoininfo.presentation.coin_detail

import com.android.cryptocoininfo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)