package com.ebayk.ads.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AdsListViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static AdsListViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(AdsListViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final AdsListViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AdsListViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
