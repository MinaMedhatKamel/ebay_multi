package com.ebayk.ads.data


import com.ebayk.data.model.AdsModel
import com.ebayk.data.network.EbayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import toAdsModel
import javax.inject.Inject


class RetrieveAdsRepository @Inject constructor(private val api: EbayApi) {
    suspend fun requestAds(id: String): AdsModel {
        return withContext(Dispatchers.IO) {
            api.getAds(id).toAdsModel()
        }
    }
}
