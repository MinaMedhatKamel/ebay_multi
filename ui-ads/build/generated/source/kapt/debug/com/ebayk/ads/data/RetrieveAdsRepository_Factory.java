package com.ebayk.ads.data;

import com.ebayk.data.network.EbayApi;
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
public final class RetrieveAdsRepository_Factory implements Factory<RetrieveAdsRepository> {
  private final Provider<EbayApi> apiProvider;

  public RetrieveAdsRepository_Factory(Provider<EbayApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RetrieveAdsRepository get() {
    return newInstance(apiProvider.get());
  }

  public static RetrieveAdsRepository_Factory create(Provider<EbayApi> apiProvider) {
    return new RetrieveAdsRepository_Factory(apiProvider);
  }

  public static RetrieveAdsRepository newInstance(EbayApi api) {
    return new RetrieveAdsRepository(api);
  }
}
