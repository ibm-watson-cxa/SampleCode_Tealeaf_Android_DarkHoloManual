/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2018
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHolo;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tl.uic.Tealeaf;

public class ControlsActivity5 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls5);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logEvent(v);
                Builder builder = new Builder(v.getContext());
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
                                        Tealeaf.logScreenLayout(ControlsActivity5.this.getParent(), "CA5", 500);
                                    }
                                });
                final AlertDialog dialog = builder.create();
                Tealeaf.logScreenLayoutSetOnShowListener(ControlsActivity5.this.getParent(), dialog);
                dialog.show();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logEvent(v);

                FragmentManager fm = getSupportFragmentManager();
                String message = getString(R.string.alertMessage2);
                MyDialogFragment alertDialog = MyDialogFragment.newInstance(message);
                alertDialog.show(fm, "fragment_alert");
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