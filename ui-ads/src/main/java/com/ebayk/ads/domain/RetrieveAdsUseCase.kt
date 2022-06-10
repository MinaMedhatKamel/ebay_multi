package com.ebayk.ads.domain

import com.ebayk.ads.data.RetrieveAdsRepository
import javax.inject.Inject

class RetrieveAdsUseCase @Inject constructor(private val repository: com.ebayk.ads.data.RetrieveAdsRepository) {
    suspend operator fun invoke(id: String) = repository.requestAds(id)
}
