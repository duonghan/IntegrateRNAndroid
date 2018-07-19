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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.testconvert.BuildConfig;
import com.testconvert.R;
import com.testconvert.modules.HoverMenuPackage;

import de.greenrobot.event.EventBus;
import io.mattcarroll.hover.Content;

/**
 * Use this class to try adding your own content to the Hover menu.
 */
public class PlaceholderCloneContent extends FrameLayout implements Content {

    private final EventBus mBus;
    private TextView mTitleTextView;
    private Context mContext;
    private Application mApplication;

    private Button btnToast;


    public PlaceholderCloneContent(@NonNull Context context, @NonNull Application application, @NonNull EventBus bus) {
        super(context);
        mBus = bus;
        mContext = context;
        mApplication = application;
        init();
    }

    private void init() {
        ReactRootView contentView = new ReactRootView(mContext);
        ReactInstanceManager mReactInstanceManager;

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(mApplication)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new HoverMenuPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        // The string here (e.g
        LayoutInflater.from(getContext()).inflate(R.layout.view_placeholder_content, this, true);
        btnToast = (Button) findViewById(R.id.btn_toast);

        //        mTitleTextView = (TextView) findViewById(R.id.textview_title);
//        contentView.startReactApplication(mReactInstanceManager, "ValaMobileApp", null);
//        RelativeLayout container = (RelativeLayout) findViewById(R.id.view_container);
//        container.addView(contentView, -1, new RelativeLayout.LayoutParams(5000, 5000));
//        LayoutInflater.from(getContext()).cloneInContext(contentView.getContext());

//        this.addView(contentView);
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

    public void onEventMainThread() {

    }
}
