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
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tl.uic.Tealeaf;

public class UICAndroidControlsAppActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	 				 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tab_layout);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        adapter = new TabAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new ControlsActivity1(), "c1");
        adapter.addFragment(new ControlsActivity2(), "c2");
        adapter.addFragment(new ControlsActivity3(), "c3");
        adapter.addFragment(new ControlsActivity4(), "c4");
        adapter.addFragment(new ControlsActivity5(), "c5");
        adapter.addFragment(new ControlsActivity6(), "c6");
        adapter.addFragment(new ControlsActivity7(), "c7");
        adapter.addFragment(new ControlsActivity8(), "c8");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        

//
//        tabHost.setOnTabChangedListener(this);
    }

//	@Override
//	public void onTabChanged(String arg0) {
//		Tealeaf.logEvent(getTabHost().getCurrentTabView(), "click");
//	}

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

//    @Override
//    public void onBackPressed() {
//        TabHost tabHost = getTabHost();  // The activity TabHost
//        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
//        Intent intent;  // Reusable Intent for each tab
//        tabHost.setCurrentTab(0);
//    }
}
