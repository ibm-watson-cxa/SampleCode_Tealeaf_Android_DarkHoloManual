/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2018
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHolo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;

import com.tl.uic.appDarkHolo.util.TLHelper;

/**
 * @author ohernandezltmac
 *
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
}
