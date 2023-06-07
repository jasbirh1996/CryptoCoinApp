package com.android.cryptocoininfo.domain.use_case.get_coins

import com.android.cryptocoininfo.common.Resource
import com.android.cryptocoininfo.data.dto.CoinDto
import com.android.cryptocoininfo.data.dto.toCoin

import com.android.cryptocoininfo.domain.model.Coin
import com.android.cryptocoininfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository : CoinRepository) {

   operator fun invoke() : Flow<Resource<List<Coin>>> = flow<Resource<List<Coin>>> {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage?:"Unexpected Error"))

        }catch (e : IOException){
            emit(Resource.Error(e.localizedMessage?:"Unexpected Error Please Check Your Internet"))
        }

    }
}