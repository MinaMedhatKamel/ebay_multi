package com.ebayk.data.factory

import com.ebayk.data.network.BasicAuthInterceptor
import com.ebayk.data.network.EbayApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createEbayApi(client: OkHttpClient): EbayApi = Retrofit
    .Builder().apply {
        client(client)
        addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        baseUrl("https://gateway.ebay-kleinanzeigen.de/coding-challenge/api/v1/")
    }
    .build()
    .create(EbayApi::class.java)


fun createAuthInterceptor(): BasicAuthInterceptor = BasicAuthInterceptor()