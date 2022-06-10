package com.ebayk.ads.ui;

import com.ebayk.ads.domain.RetrieveAdsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AdsListViewModel_Factory implements Factory<AdsListViewModel> {
  private final Provider<RetrieveAdsUseCase> retrieveAdsUseCaseProvider;

  public AdsListViewModel_Factory(Provider<RetrieveAdsUseCase> retrieveAdsUseCaseProvider) {
    this.retrieveAdsUseCaseProvider = retrieveAdsUseCaseProvider;
  }

  @Override
  public AdsListViewModel get() {
    return newInstance(retrieveAdsUseCaseProvider.get());
  }

  public static AdsListViewModel_Factory create(
      Provider<RetrieveAdsUseCase> retrieveAdsUseCaseProvider) {
    return new AdsListViewModel_Factory(retrieveAdsUseCaseProvider);
  }

  public static AdsListViewModel newInstance(RetrieveAdsUseCase retrieveAdsUseCase) {
    return new AdsListViewModel(retrieveAdsUseCase);
  }
}
