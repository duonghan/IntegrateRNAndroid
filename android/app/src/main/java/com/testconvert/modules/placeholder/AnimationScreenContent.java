/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.testconvert.modules.placeholder;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.testconvert.BuildConfig;

import io.mattcarroll.hover.Content;

/**
 * Use this class to try adding your own content to the Hover menu.
 */
public class AnimationScreenContent extends FrameLayout implements Content {
    private TextView mTitleTextView;
    private Context mContext;
    private Application mApplication;


    public AnimationScreenContent(@NonNull Context context, @NonNull Application application) {
        super(context);
        mContext = context;
        mApplication = application;
        init();
    }

    private void init() {
        ReactRootView contentView = new ReactRootView(mContext);
        ReactInstanceManager mReactInstanceManager;

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication((Application) this.getContext().getApplicationContext())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        contentView.startReactApplication(mReactInstanceManager, "HelloScreen", null);
        this.addView(contentView);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        mBus.registerSticky(this);
    }

    @Override
    protected void onDetachedFromWindow() {
//        mBus.unregister(this);
        super.onDetachedFromWindow();
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public boolean isFullscreen() {
        return true;
    }

    @Override
    public void onShown() {

    }

    @Override
    public void onHidden() {

    }

}
