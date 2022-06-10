package com.ebayk.ads.domain;

import com.ebayk.ads.data.RetrieveAdsRepository;
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
public final class RetrieveAdsUseCase_Factory implements Factory<RetrieveAdsUseCase> {
  private final Provider<RetrieveAdsRepository> repositoryProvider;

  public RetrieveAdsUseCase_Factory(Provider<RetrieveAdsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RetrieveAdsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static RetrieveAdsUseCase_Factory create(
      Provider<RetrieveAdsRepository> repositoryProvider) {
    return new RetrieveAdsUseCase_Factory(repositoryProvider);
  }

  public static RetrieveAdsUseCase newInstance(RetrieveAdsRepository repository) {
    return new RetrieveAdsUseCase(repository);
  }
}
