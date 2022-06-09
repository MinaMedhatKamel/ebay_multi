package com.ebayk.data.repository

import com.ebayk.data.model.AdsModel
import com.ebayk.data.network.EbayApi
import toAdsModel


class RetrieveAdsRepository(private val api: EbayApi) {
    suspend fun requestAds(id: String): AdsModel = api.getAds(id).toAdsModel()
}
