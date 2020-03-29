package com.fof.graphics;

import com.fof.graphics.util.FPSGetter;

public class Skipper {
    private int SetFPS = 60;
    private FPSGetter getter;

    public Skipper(FPSGetter getter) {
        this.getter = getter;
    }

    public boolean isSkip() {
        return SetFPS > getter.getFPS();
    }
}
