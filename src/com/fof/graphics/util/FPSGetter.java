package com.fof.graphics.util;

public class FPSGetter {
    public static FPSGetter INSTANCE = new FPSGetter();
    private long before_long = System.currentTimeMillis();
    private long now_long = System.currentTimeMillis();
    private double FPS = 0;

    /**
     * @apiNote Please Call once in Frame
     */
    public void tick() {
        now_long = System.currentTimeMillis();
        setFPS(now_long - before_long);
        before_long = System.currentTimeMillis();
    }

    private void setFPS(long mill) {
        if (mill == 0) {
            FPS = 1000;
            return;
        }
        FPS = 1000 / mill;
    }

    public int getFPS() {
        tick();
        return (int) FPS;
    }
}
