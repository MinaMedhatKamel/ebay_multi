package com.ebayk.ads.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebayk.data.model.AdsModel
import com.ebayk.domain.usecase.retrieveads.RetrieveAdsUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ads view model integrated with hilt to provide the parameters dependancies
 * @param retrieveAdsUseCase use case for handling the data retrieving of the ads.
 */
@HiltViewModel
class AdsListViewModel @Inject constructor(
    private val retrieveAdsUseCase: RetrieveAdsUseCase
) : ViewModel() {

    val state = mutableStateOf<AdsListUiState>(Loading)

    init {
        retrieveAds()
    }


    private fun retrieveAds() = viewModelScope.launch {
        state.value = Loading
        state.value = AdsListReady(retrieveAdsUseCase.invoke())
    }

}

sealed class AdsListUiState
data class AdsListReady(val ads: AdsModel) : AdsListUiState()
object Loading : AdsListUiState()
