/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2016
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHolo;

import com.tl.uic.Tealeaf;
import com.tl.uic.appDarkHolo.R;
import com.tl.uic.appDarkHolo.util.TLHelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author ohernandezltmac
 *
 */
public class ControlsActivity1 extends AppCompatActivity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.controls1);

	    TextView t = (TextView) findViewById(R.id.textView1);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) findViewById(R.id.textView2);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) findViewById(R.id.textView3);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) findViewById(R.id.textView4);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    
	    Button b = (Button) findViewById(R.id.button5);
	    b.setOnClickListener(TLHelper.getOnClickListener());
	    
	    b = (Button) findViewById(R.id.button6);
	    b.setOnClickListener(TLHelper.getOnClickListener());
	    
	    ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
	    ib.setOnClickListener(TLHelper.getOnClickListener());
	    
	    ImageView iv = (ImageView) findViewById(R.id.imageView1);
	    iv.setOnClickListener(TLHelper.getOnClickListener());
	    
	    ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton1);
	    tb.setOnClickListener(TLHelper.getOnClickListener());
	    
	    MediaController mc = (MediaController) findViewById(R.id.mediaController1);
	    mc.setOnClickListener(TLHelper.getOnClickListener());
	    
	    CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);
	    cb.setOnClickListener(TLHelper.getOnClickListener());


		// Instrumentation for Scrollview screen capture
		final NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.scrollView1);
		final Activity activity = this;

		scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
			@Override
			public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				// Scroll offset before calling Tealeaf Logscreen API
				if (scrollY - oldScrollY > 100) {
					Tealeaf.logScreenLayout(activity, "CustomScrollViewLog");
				}
			}
		});

		Button logScreenButton = (Button) findViewById(R.id.buttonCaptureScreen);

		logScreenButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Tealeaf.logScreenLayout(activity, "CustomButtonLog", 10);

			}
		});
	}
}
