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

import com.tl.uic.Tealeaf;
import com.tl.uic.app.UICApplication;

public class MyApplication extends UICApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        Tealeaf.enable();
    }
}
