/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jim.mrpotatoheadactivity;

import android.app.Activity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import android.view.View;
import android.widget.ImageView;
import android.widget.CheckBox;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.util.Log;


/**
 * A minimal "Hello, World!" application.
 */
public class MrPotatoHeadActivity extends Activity {
    /**
     * Called with the activity is first created.
     */

    public static Map bodyparts;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity.  You can find it
        // in res/layout/hello_activity.xml
        //Context context = new Context();
        View view = getLayoutInflater().inflate(R.layout.mrpotatohead_activity, null);
        setContentView(view);
        Map <Integer, Integer> bodyparts = new HashMap<Integer, Integer>();
        bodyparts.put(R.id.check_nose, R.id.nose);
        bodyparts.put(R.id.check_ears, R.id.ears);
        bodyparts.put(R.id.check_mouth, R.id.mouth);
        bodyparts.put(R.id.check_arms, R.id.arms);
        bodyparts.put(R.id.check_mustache, R.id.mustache);
        bodyparts.put(R.id.check_hat, R.id.hat);
        bodyparts.put(R.id.check_eyebrows, R.id.eyebrows);
        bodyparts.put(R.id.check_glasses, R.id.glasses);
        bodyparts.put(R.id.check_shoes, R.id.shoes);
        bodyparts.put(R.id.check_eyes, R.id.eyes);
        addListeners(bodyparts);
    }

    public void addListeners(final Map<Integer,Integer> bodyparts){
        for (final int part:bodyparts.keySet()) {
            CheckBox check = (CheckBox) findViewById(part);
            check.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    final ImageView image = (ImageView) findViewById(bodyparts.get(part));
                    if (((CheckBox) v).isChecked()){
                        image.setVisibility(View.VISIBLE);
                    }
                    else {
                        image.setVisibility(View.INVISIBLE);
                    }
                }
            });
            if (bodyparts.get(part) != R.id.body) {
                ImageView image = (ImageView) findViewById(bodyparts.get(part));
                image.setVisibility(View.INVISIBLE);
            }
        }
    }
}
