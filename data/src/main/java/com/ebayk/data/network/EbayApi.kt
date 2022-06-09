package com.ebayk.data.network

import EbayResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface EbayApi {
    @GET("ads/{ad_id}")
    suspend fun getAds(
        @Path("ad_id") id: String
    ): EbayResponse
}
