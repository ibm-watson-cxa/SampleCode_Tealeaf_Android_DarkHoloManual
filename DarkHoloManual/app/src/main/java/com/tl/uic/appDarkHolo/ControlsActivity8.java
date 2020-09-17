/********************************************************************************************
 * Copyright (C) 2020 Acoustic, L.P. All rights reserved.
 *
 * NOTICE: This file contains material that is confidential and proprietary to
 * Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
 * industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
 * Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
 * prohibited.
 ********************************************************************************************/
package com.tl.uic.appDarkHolo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import com.tl.uic.Tealeaf;
import com.tl.uic.appDarkHolo.util.TLHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * @author ohernandezltmac
 */
public class ControlsActivity8 extends BaseFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls8, container, false);

        Switch sUw = v.findViewById(R.id.saveUname_switch);
        sUw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());

        Switch sw = v.findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());

        Button button = v.findViewById(R.id.button1);
        final HashMap<String, String> data = new HashMap<>();
        data.put("Foo", "Bar");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logCustomEvent("MyEvent", data);
            }
        });

        button = v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = data.get("key");
                if(value == null) {
                    Tealeaf.logException(new Exception("Custom Exception"));
                }
            }
        });

        button = v.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String imageUrl= "https://acoustic.com/";
                            URL url = new URL(imageUrl);
                            HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
                            Tealeaf.logConnection(imageUrl, 0, 0,  0, connection.getContentLength(), connection.getResponseCode());
                        } catch (Exception e) {
                            Tealeaf.logException(e);
                        }
                    }
                });
                thread.start();
            }
        });

        button = v.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String imageUrl= "http://www.google.com/";
                            URL url = new URL(imageUrl);
                            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.connect();
                            Tealeaf.logConnection(imageUrl, 0, 0,  0, connection.getContentLength(), connection.getResponseCode());
                        } catch (Exception e) {
                            Tealeaf.logException(e);
                        }
                    }
                });
                thread.start();
            }
        });


        button = v.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logFormCompletion(true, true);
            }
        });
        return v;
    }

    /* Add touch event to collect gestures for Tealeaf.
     *
     * (non-Javadoc)
     * @see android.app.Activity#dispatchTouchEvent(android.view.MotionEvent)
     */
//    public boolean dispatchTouchEvent(MotionEvent e)
//    {
//        Tealeaf.dispatchTouchEvent(this, e);
//        return super.dispatchTouchEvent(e);
//    }
}
