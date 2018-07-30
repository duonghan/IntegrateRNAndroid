package com.testconvert.modules;

import android.app.Application;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.testconvert.BuildConfig;

public class ValaReactInstanceManager{
   private static ReactInstanceManager mInstance;

    public static ReactInstanceManager getInstance() {
        return mInstance;
    }

    public static void setInstance(ReactInstanceManager instance) {
        mInstance = instance;
    }

    public static void setInstance(Application mApplication) {
        mInstance = ReactInstanceManager.builder()
                .setApplication(mApplication)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
    }
}
