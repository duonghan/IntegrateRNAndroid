package com.testconvert.modules.services;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;


import com.testconvert.R;
import com.testconvert.modules.HoverMenuScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.mattcarroll.hover.HoverMenu;
import io.mattcarroll.hover.HoverView;
import io.mattcarroll.hover.window.HoverMenuService;

public class MultipleSectionsHoverMenuService extends HoverMenuService {
    private static final String TAG = "MultipleSectionsHoverMenuService";

    @Override
    protected void onHoverMenuLaunched(@NonNull Intent intent, @NonNull HoverView hoverView) {
        hoverView.setMenu(createHoverMenu());
        hoverView.collapse();
    }

    @NonNull
    private HoverMenu createHoverMenu() {
        return new MultiSectionHoverMenu(getApplicationContext());
    }

    private static class MultiSectionHoverMenu extends HoverMenu {

        private final Context mContext;
        private final List<Section> mSections;

        public MultiSectionHoverMenu(@NonNull Context context) {
            mContext = context.getApplicationContext();

            mSections = Arrays.asList(
                new Section(
                    new SectionId("1"),
                    createTabView(1),
                    new HoverMenuScreen(mContext, "Screen 1")
                ),
                new Section(
                    new SectionId("2"),
                    createTabView(2),
                    new HoverMenuScreen(mContext, "Screen 2")
                ),
                new Section(
                    new SectionId("3"),
                    createTabView(3),
                    new HoverMenuScreen(mContext, "Screen 3")
                )
            );
        }

        private View createTabView(int sectionId) {
            ImageView imageView = new ImageView(mContext);
            switch (sectionId){
                case 1:
                    imageView.setImageResource(R.drawable.tab_background);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.tab_background_blue);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.tab_background_pink);
                    break;
                default:
                    imageView.setImageResource(R.drawable.tab_background);
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return imageView;
        }

        @Override
        public String getId() {
            return "multisectionmenu";
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
}


