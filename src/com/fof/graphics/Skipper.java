package com.fof.graphics;

import com.fof.graphics.util.FPSGetter;

public class Skipper {
    public static Skipper INSTANCE = new Skipper();
    private int SetFPS = 60;

    private Skipper() {

    }

    public boolean isSkip() {
        return SetFPS > FPSGetter.INSTANCE.getFPS();
    }
}
