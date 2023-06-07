package com.android.cryptotracker.domain.use_case.get_coin_detail

import com.android.cryptotracker.common.Resource
import com.android.cryptotracker.data.dto.toCoinDetail

import com.android.cryptotracker.domain.model.CoinDetail
import com.android.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

    class GetCoinDetailUseCase @Inject constructor(private val repository : CoinRepository) {

      operator fun invoke(id : String) : Flow<Resource<CoinDetail>> = flow {
            try {
                emit(Resource.Loading())
                val coinDetail = repository.getCoinById(id).toCoinDetail()
                emit(Resource.Success<CoinDetail>(coinDetail))

            }catch (e : HttpException){
                emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Unexpected Error"))

            }catch (e : IOException){
                emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Unexpected Error Please Check Your Internet"))
            }

        }

    }
