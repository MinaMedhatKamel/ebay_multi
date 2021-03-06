package com.ebayk.ads.ui;

import java.lang.System;

/**
 * ads view model integrated with hilt to provide the parameters dependancies
 * @param retrieveAdsUseCase use case for handling the data retrieving of the ads.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/ebayk/ads/ui/AdsListViewModel;", "Landroidx/lifecycle/ViewModel;", "retrieveAdsUseCase", "Lcom/ebayk/ads/domain/RetrieveAdsUseCase;", "(Lcom/ebayk/ads/domain/RetrieveAdsUseCase;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "state", "Landroidx/compose/runtime/MutableState;", "Lcom/ebayk/ads/ui/AdsListUiState;", "getState", "()Landroidx/compose/runtime/MutableState;", "retrieveAds", "Lkotlinx/coroutines/Job;", "ui-ads_debug"})
public final class AdsListViewModel extends androidx.lifecycle.ViewModel {
    private final com.ebayk.ads.domain.RetrieveAdsUseCase retrieveAdsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.ebayk.ads.ui.AdsListUiState> state = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    
    @javax.inject.Inject()
    public AdsListViewModel(@org.jetbrains.annotations.NotNull()
    com.ebayk.ads.domain.RetrieveAdsUseCase retrieveAdsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.ebayk.ads.ui.AdsListUiState> getState() {
        return null;
    }
    
    private final kotlinx.coroutines.Job retrieveAds() {
        return null;
    }
}