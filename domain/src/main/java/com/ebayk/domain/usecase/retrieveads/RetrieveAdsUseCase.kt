package com.ebayk.domain.usecase.retrieveads

import com.ebayk.data.repository.RetrieveAdsRepository
import javax.inject.Inject

class RetrieveAdsUseCase @Inject constructor(private val repository: RetrieveAdsRepository) {
    suspend operator fun invoke(id: String) = repository.requestAds(id)
}
