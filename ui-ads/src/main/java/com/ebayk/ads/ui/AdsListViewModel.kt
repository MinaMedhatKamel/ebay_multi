package com.ebayk.ads.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebayk.data.model.AdsModel
import com.ebayk.ads.domain.RetrieveAdsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        state.value = Error(throwable.message ?: "Something went wrong")
    }

    init {
        retrieveAds()
    }


    private fun retrieveAds() = viewModelScope.launch(exceptionHandler) {
        state.value = Loading
        state.value = AdsListReady(retrieveAdsUseCase.invoke("1118635128"))
    }

}

sealed class AdsListUiState
data class AdsListReady(val ads: AdsModel) : AdsListUiState()
object Loading : AdsListUiState()
data class Error(val string: String) : AdsListUiState()
