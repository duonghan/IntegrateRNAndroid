package com.testconvert.modules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import io.mattcarroll.hover.Content;

public class HoverMenuScreen implements Content {

    private final Context mContext;
    private final String mPageTitle;
    private final View mWholeScreen;

    public HoverMenuScreen(@NonNull Context context, @NonNull String pageTitle) {
        mContext = context.getApplicationContext();
        mPageTitle = pageTitle;
        mWholeScreen = createScreenView();
        mWholeScreen.setBackgroundColor(0xFFFFFFFF);
    }

    @NonNull
    private View createScreenView() {
        TextView wholeScreen = new TextView(mContext);
        wholeScreen.setText("Screen: " + mPageTitle);
        wholeScreen.setGravity(Gravity.CENTER);
        return wholeScreen;
    }


    @NonNull
    @Override
    public View getView() {
        return mWholeScreen;
    }

    @Override
    public boolean isFullscreen() {
        return true;
    }

    @Override
    public void onShown() {
        // No-op
    }

    @Override
    public void onHidden() {
        // No-op
    }
}
