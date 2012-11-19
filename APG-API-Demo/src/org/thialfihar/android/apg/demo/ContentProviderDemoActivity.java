/*
 * Copyright (C) 2012 Dominik Schürmann <dominik@dominikschuermann.de>
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

package org.thialfihar.android.apg.demo;

import java.util.Arrays;

import org.thialfihar.android.apg.demo.R;
import org.thialfihar.android.apg.integration.ApgContentProviderHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentProviderDemoActivity extends Activity {
    Activity mActivity;

    TextView mOutputTextView;
    TextView mCiphertextTextView;
    TextView mDataTextView;

    ApgContentProviderHelper mApgContentProviderHelper;

    /**
     * Instantiate View for this Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_provider_demo);

        mActivity = this;

        mOutputTextView = (TextView) findViewById(R.id.content_provider_output);

        mApgContentProviderHelper = new ApgContentProviderHelper(mActivity);
    }

    public void test1OnClick(View view) {
        long[] test = mApgContentProviderHelper.getPublicKeyIdsFromEmail("user@example.com");
        mOutputTextView.setText(Arrays.toString(test));
    }

    public void test2OnClick(View view) {
        boolean test = mApgContentProviderHelper.hasPublicKeyForEmail("user@example.com");
        if (test) {
            mOutputTextView.setText("true");
        } else {
            mOutputTextView.setText("false");
        }
    }

}
