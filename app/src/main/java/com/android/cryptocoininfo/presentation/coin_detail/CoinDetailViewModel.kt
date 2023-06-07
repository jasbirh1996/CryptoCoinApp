package com.android.cryptocoininfo.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.cryptocoininfo.common.Constants
import com.android.cryptocoininfo.common.Resource
import com.android.cryptocoininfo.domain.use_case.get_coin_detail.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val coinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.Coin_Id)?.let {
            getCoinDetail(id = it)
        }
    }

    private fun getCoinDetail(id: String) {
        coinDetailUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "An unexpected error occur")
                }
            }

        }.launchIn(viewModelScope)

    }
}