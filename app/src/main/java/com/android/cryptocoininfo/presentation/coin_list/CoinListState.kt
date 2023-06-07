package com.android.cryptocoininfo.presentation.coin_list

import com.android.cryptocoininfo.common.Resource
import com.android.cryptocoininfo.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coinList : List<Coin> = emptyList(),
    val error: String = ""
)
