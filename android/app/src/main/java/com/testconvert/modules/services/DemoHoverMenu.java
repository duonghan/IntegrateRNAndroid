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
package com.testconvert.modules.services;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;

import com.testconvert.R;
import com.testconvert.modules.ui.DemoTabView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.mattcarroll.hover.Content;
import io.mattcarroll.hover.HoverMenu;

/**
 * Demo implementation of a {@link HoverMenu}.
 */
public class DemoHoverMenu extends HoverMenu {

    public static final String INTRO_ID = "intro";
    public static final String HELLO_ID = "hello screen";
    public static final String ANIMATION_ID = "animation screen";

    private final Context mContext;
    private final String mMenuId;
    private final List<Section> mSections = new ArrayList<>();

    public DemoHoverMenu(@NonNull Context context,
                         @NonNull String menuId,
                         @NonNull Map<String, Content> data) throws IOException {
        mContext = context;
        mMenuId = menuId;

        for (String tabId : data.keySet()) {
            mSections.add(new Section(
                    new SectionId(tabId),
                    createTabView(tabId),
                    data.get(tabId)
            ));
        }
    }

    // Add icon to tab view (tab circle button)
    private View createTabView(String sectionId) {
        return createTabView(R.drawable.ic_orange_circle);
//        if (INTRO_ID.equals(sectionId)) {
//            return createTabView(R.drawable.ic_orange_circle);
//        } else {
//            throw new RuntimeException("Unknown tab selected: " + sectionId);
//        }
    }

    private View createTabView(@DrawableRes int tabBitmapRes) {
        Resources resources = mContext.getResources();
        int elevation = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, resources.getDisplayMetrics());

        DemoTabView view = new DemoTabView(mContext, resources.getDrawable(R.drawable.tab_background), resources.getDrawable(tabBitmapRes));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setElevation(elevation);
        }
        return view;
    }

    @Override
    public String getId() {
        return mMenuId;
    }

    @Override
    public int getSectionCount() {
        return mSections.size();
    }

    @Nullable
    @Override
    public Section getSection(int index) {
        return mSections.get(index);
    }

    @Nullable
    @Override
    public Section getSection(@NonNull SectionId sectionId) {
        for (Section section : mSections) {
            if (section.getId().equals(sectionId)) {
                return section;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public List<Section> getSections() {
        return new ArrayList<>(mSections);
    }
}
