/********************************************************************************************
 * Copyright (C) 2018 Acoustic, L.P. All rights reserved.
 *
 * NOTICE: This file contains material that is confidential and proprietary to
 * Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
 * industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
 * Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
 * prohibited.
 ********************************************************************************************/
package com.tl.uic.appDarkHolo;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MotionEvent;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.tl.uic.Tealeaf;

public class ControlsActivity5 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls5, container, false);

        Button button = (Button) v.findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logEvent(v);
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                String title = getString(R.string.alertTitle);
                String message = getString(R.string.alertMessage1);
                builder.setMessage(message)
                        .setTitle(title)
                        .setCancelable(false)
                        .setNegativeButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Tealeaf.logDialogEvent(dialog, id);
                                        dialog.cancel();
                                        Tealeaf.logScreenLayout(ControlsActivity5.this.getActivity().getParent(), "CA5", 500);
                                    }
                                });
                final AlertDialog dialog = builder.create();
                Tealeaf.logScreenLayoutSetOnShowListener(ControlsActivity5.this.getActivity().getParent(), dialog);
                dialog.show();
            }
        });

        button = (Button) v.findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logEvent(v);

                FragmentManager fm = getActivity().getSupportFragmentManager();
                String message = getString(R.string.alertMessage2);
                MyDialogFragment alertDialog = MyDialogFragment.newInstance(message);
                alertDialog.show(fm, "fragment_alert");
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
