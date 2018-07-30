package com.testconvert;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.testconvert.modules.HoverMenuPackage;
import com.testconvert.modules.ValaReactInstanceManager;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "TestConvert";
        // return "ButtonScreen";
    }
}
