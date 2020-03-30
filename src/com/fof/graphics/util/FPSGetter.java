package com.fof.graphics.util;

import com.fof.game.debug.DebugViewer;
import com.fof.graphics.Drawable;

public class FPSGetter implements DebugViewer {
    public static FPSGetter INSTANCE = new FPSGetter();
    private long before_long = System.nanoTime();
    private long now_long = System.nanoTime();
    private long frame_Nano;
    private double FPS = 0;

    /**
     * @apiNote Please Call once in Frame
     */
    public void tick() {
        now_long = System.nanoTime();
        frame_Nano = now_long - before_long;
        setFPS(frame_Nano);
        //fof_game.INSTANCE.LOGGER.println("FPS:" + FPS);
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

    public long getNano() {
        return frame_Nano;
    }

    public long getMill() {
        return getNano() / 1000000;
    }

    @Override
    public Drawable getDrawable() {
        return new Drawable("FPS:" + getFPS(), 100, 100);
    }
}
