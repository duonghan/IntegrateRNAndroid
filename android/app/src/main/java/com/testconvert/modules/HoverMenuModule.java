package com.testconvert.modules;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.testconvert.modules.services.DemoHoverMenuService;

import io.mattcarroll.hover.overlay.OverlayPermission;

public class HoverMenuModule extends ReactContextBaseJavaModule {

    private static final int REQUEST_CODE_HOVER_PERMISSION = 1000;

    private boolean mPermissionsRequested = false;

    public HoverMenuModule(final ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            @Override
            public void onHostResume() {
                if (!mPermissionsRequested && !OverlayPermission.hasRuntimePermissionToDrawOverlay(reactContext)) {
                    @SuppressWarnings("NewApi")
                    Intent myIntent = OverlayPermission.createIntentToRequestOverlayPermission(reactContext);
                    getReactApplicationContext().startActivityForResult(myIntent, REQUEST_CODE_HOVER_PERMISSION, null);
                }
            }

            @Override
            public void onHostPause() {

            }

            @Override
            public void onHostDestroy() {

            }
        });

        reactContext.addActivityEventListener(new ActivityEventListener() {
            @Override
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                if (REQUEST_CODE_HOVER_PERMISSION == requestCode) {
                    mPermissionsRequested = true;
                } else {
                    getReactApplicationContext().onActivityResult(activity, requestCode, resultCode, data);
                }
            }

            @Override
            public void onNewIntent(Intent intent) {

            }
        });
    }

    @Override
    public String getName() {
        return "HoverMenuModule";
    }

    @ReactMethod
    public void show(){
        Toast.makeText(getReactApplicationContext(), "Start Hover Intent", Toast.LENGTH_SHORT).show();
        Intent startHoverIntent = new Intent(getReactApplicationContext(), DemoHoverMenuService.class);
        getReactApplicationContext().startService(startHoverIntent);
//        getReactApplicationContext().startActivity(startHoverIntent);
        getCurrentActivity().finish();
    }
}
