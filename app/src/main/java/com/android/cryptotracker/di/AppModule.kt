package com.android.cryptotracker.di

import com.android.cryptotracker.common.ApiLogger
import com.android.cryptotracker.common.Constants
import com.android.cryptotracker.data.remote.CoinPaprikaApi
import com.android.cryptotracker.data.repository.CoinRepositoryImp
import com.android.cryptotracker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): CoinPaprikaApi {

        val client = OkHttpClient.Builder()
        val logger = HttpLoggingInterceptor(ApiLogger())
        logger.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logger)

        return Retrofit.Builder().baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build().create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImp(api)
    }
}