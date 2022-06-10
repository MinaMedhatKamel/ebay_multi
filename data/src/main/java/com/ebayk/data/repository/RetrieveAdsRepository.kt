package com.ebayk.data.repository

import com.ebayk.data.model.AdsModel
import com.ebayk.data.network.EbayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import toAdsModel


class RetrieveAdsRepository(private val api: EbayApi) {
    suspend fun requestAds(id: String): AdsModel {
       return withContext(Dispatchers.IO) {
            api.getAds(id).toAdsModel()
        }
    }
}
