package com.example.msi.a123;

import io.skygear.skygear.SkygearApplication;

public class MyApplication extends SkygearApplication {
    @Override
    public String getSkygearEndpoint() {
        return "https://logintest.skygeario.com/";
    }

    @Override
    public String getApiKey() {
        return "9136a37f9682434ebd8579fba16f0369";
    }
}
