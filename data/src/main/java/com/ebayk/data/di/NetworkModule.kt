package com.ebayk.data.di

import com.ebayk.data.BuildConfig
import com.ebayk.data.factory.createAuthInterceptor
import com.ebayk.data.factory.createEbayApi
import com.ebayk.data.network.BasicAuthInterceptor
import com.ebayk.data.network.EbayApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * hilt module for providing the data layer dependencies
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesHttpLogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideAuthInterceptor(): BasicAuthInterceptor = createAuthInterceptor()


    @Provides
    fun providesOkHTTPClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: BasicAuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(authInterceptor)
                if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
            }.build()
    }

    @Provides
    fun provideEbayApi(client: OkHttpClient): EbayApi = createEbayApi(client)
}
