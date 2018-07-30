package com.testconvert;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.testconvert.modules.HoverMenuPackage;
import com.testconvert.modules.ValaReactInstanceManager;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new HoverMenuPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);

//    ReactInstanceManager mReactInstanceManager = ReactInstanceManager.builder()
//            .setApplication(this)
//            .setBundleAssetName("index.android.bundle")
//            .setJSMainModulePath("index")
//            .addPackage(new HoverMenuPackage())
//            .setUseDeveloperSupport(BuildConfig.DEBUG)
//            .setInitialLifecycleState(LifecycleState.RESUMED)
//            .build();
//
//    ValaReactInstanceManager.setInstance(mReactInstanceManager);
  }
}
