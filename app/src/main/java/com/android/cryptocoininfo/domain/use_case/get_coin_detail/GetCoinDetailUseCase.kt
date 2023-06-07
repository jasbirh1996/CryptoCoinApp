package com.android.cryptocoininfo.domain.use_case.get_coin_detail

import com.android.cryptocoininfo.common.Resource
import com.android.cryptocoininfo.data.dto.CoinDetailDto
import com.android.cryptocoininfo.data.dto.toCoin
import com.android.cryptocoininfo.data.dto.toCoinDetail

import com.android.cryptocoininfo.domain.model.Coin
import com.android.cryptocoininfo.domain.model.CoinDetail
import com.android.cryptocoininfo.domain.repository.CoinRepository
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
