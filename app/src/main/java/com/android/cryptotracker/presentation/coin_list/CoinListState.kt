package com.android.cryptotracker.presentation.coin_list

import com.android.cryptotracker.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coinList : List<Coin> = emptyList(),
    val error: String = ""
)
