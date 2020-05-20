/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2019
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHolo;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.tl.uic.Tealeaf;
import com.tl.uic.appDarkHolo.util.TLHelper;
import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * @author ohernandezltmac
 */
public class ControlsActivity8 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls8);

        Switch sUw = findViewById(R.id.saveUname_switch);
        sUw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());

        Button button = findViewById(R.id.button1);
        final HashMap<String, String> data = new HashMap<>();
        data.put("Foo", "Bar");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logCustomEvent("MyEvent", data);
            }
        });

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = data.get("key");
                if(value == null) {
                    Tealeaf.logException(new Exception("Custom Exception"));
                }
            }
        });

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String imageUrl= "https://www.google.com";
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

        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logFormCompletion(true, true);
            }
        });
    }

    /* Add touch event to collect gestures for Tealeaf.
     *
     * (non-Javadoc)
     * @see android.app.Activity#dispatchTouchEvent(android.view.MotionEvent)
     */
    public boolean dispatchTouchEvent(MotionEvent e)
    {
        Tealeaf.dispatchTouchEvent(this, e);
        return super.dispatchTouchEvent(e);
    }
}
