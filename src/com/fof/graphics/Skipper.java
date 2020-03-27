package com.fof.graphics;

import com.fof.game.main.fof_game;

import java.util.Date;

public class Skipper {
    public static Skipper INSTANCE = new Skipper();
    private long before_time;
    private int SetFPS = 60;
    private long nowTime;
    private int perFrameTime;
    private Date date = new Date();

    private Skipper() {
        before_time = date.getTime();
        perFrameTime = 1000 / SetFPS;
    }

    public boolean isSkip() {
        nowTime = date.getTime();
        fof_game.INSTANCE.LOGGER.println("The Frame took " + (nowTime - before_time) + "mills");
        if (nowTime - before_time > perFrameTime) {
            before_time = date.getTime();
            return true;
        } else {
            before_time = date.getTime();
            return false;
        }
    }
}
