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

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.testconvert.modules.placeholder.PlaceholderCloneContent;
import com.testconvert.modules.placeholder.PlaceholderContent;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
import io.mattcarroll.hover.Content;

/**
 * Can create a Hover menu from code or from file.
 */
public class DemoHoverMenuFactory {

    /**
     * Example of how to create a menu in code.
     * @return HoverMenu
     */
    public DemoHoverMenu createDemoMenuFromCode(@NonNull Context context, @NonNull EventBus bus, Application application) throws IOException {

        Map<String, Content> demoMenu = new LinkedHashMap<>();
        demoMenu.put(DemoHoverMenu.INTRO_ID, new PlaceholderContent(context, application, Bus.getInstance()));
        demoMenu.put(DemoHoverMenu.INTRO_ID_CLONE, new PlaceholderCloneContent(context, application, Bus.getInstance()));

        return new DemoHoverMenu(context, "demo_vala", demoMenu);
    }

}