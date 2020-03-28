package com.fof.graphics.util;

import com.fof.game.main.fof_game;

public class FPSGetter {
    public static FPSGetter INSTANCE = new FPSGetter();
    private long before_long = System.nanoTime();
    private long now_long = System.nanoTime();
    private double FPS = 0;

    /**
     * @apiNote Please Call once in Frame
     */
    public void tick() {
        now_long = System.nanoTime();
        setFPS(now_long - before_long);
        fof_game.INSTANCE.LOGGER.println("FPS:" + FPS);
        before_long = System.nanoTime();
    }

    private void setFPS(long nano) {
        if (nano == 0) {
            FPS = 1000001;
            return;
        }
        FPS = 1000000000 / nano;
    }

    public int getFPS() {
        return (int) FPS;
    }
}
