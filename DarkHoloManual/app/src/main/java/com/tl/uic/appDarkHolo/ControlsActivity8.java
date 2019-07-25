/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2019
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHolo;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Switch;

import com.tl.uic.Tealeaf;
import com.tl.uic.appDarkHolo.util.TLHelper;
import androidx.appcompat.app.AppCompatActivity;

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
