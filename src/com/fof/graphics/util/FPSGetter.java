package com.fof.graphics.util;

import com.fof.game.debug.DebugViewer;
import com.fof.graphics.Drawable;
import com.fof.map.pos.onDisplayPos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FPSGetter implements DebugViewer {
    public static FPSGetter INSTANCE = new FPSGetter();
    private long before_long = System.nanoTime();
    private long now_long = System.nanoTime();
    private long start_time = System.nanoTime();
    private long frames_count = 0;
    private long frame_Nano;
    private double FPS = 0;

    /**
     * @apiNote Please Call once in Frame
     * @deprecated
     */
    public void tick() {
        update();
    }

    @Deprecated
    private void setFPS(long nano, long frames_count) {
        FPS = getPerFrameTime(nano, frames_count);
    }

    /**
     * @param nano
     * @param frames_count
     * @return
     * @apiNote (単位はnmです)
     */
    private long getPerFrameTime(long nano, long frames_count) {
        return nano / frames_count;
    }

    public double getFPS() {
        return getOnePerFPS();
    }

    @Deprecated
    public long getNano() {
        return frame_Nano;
    }

    @Deprecated
    public long getMill() {
        return getNano() / 1000000;
    }

    @Override
    public Drawable getDrawable() {
        return new Drawable("FPS:" + getFPS(), new onDisplayPos(100, 100));
    }


    /**
     * @author nyuto
     */
    long lastUpdate;
    long lastTime;
    long updateTime;
    long averageTime;
    long longestTime;
    long onePerTime;
    List<Long> timeList;

    /**
     * @author nyuto and bun133(What I done?)
     */
    public FPSGetter() {
        lastTime = System.nanoTime();
        averageTime = 0;
        longestTime = 0;
        onePerTime = 0;
        timeList = new ArrayList<Long>();
    }

    public void update() {
        long time = System.nanoTime();
        timeList.add(time - lastUpdate);
        lastTime = time - lastUpdate;
        lastUpdate = time;
        if (updateTime <= time) {
            //1秒後更新のため1秒分加算
            updateTime = time + 1000000000;
            Object[] tmp = timeList.toArray();
            long[] times = new long[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                times[i] = (long) tmp[i];
            }
            Arrays.sort(times);
            long average = 0;
            long onePer = 0;
            int onePers = times.length / 100;
            if (onePers == 0) onePers = 1;
            for (int i = 0; i < times.length; i++) {
                average += times[i];
            }
            for (int i = 0; i < onePers; i++) {
                onePer += times[i];
            }
            averageTime = average / times.length;
            onePerTime = onePer / onePers;
            longestTime = times[times.length - 1];
            timeList = new ArrayList<Long>();
        }
    }


    public long getAverageTime() {
        return averageTime;
    }


    public long getLongestTime() {
        return longestTime;
    }


    public long getOnePerTime() {
        return onePerTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    /**
     * @return 1秒間の平均FPS
     */
    public double getAverageFPS() {
        return timeToFPS(averageTime);
    }

    /**
     * @return 1秒間の最長描画時間に対するFPS
     */
    public double getLongestFPS() {
        return timeToFPS(longestTime);
    }

    /**
     * @return 1秒間の上位1%のFPS
     */
    public double getOnePerFPS() {
        return timeToFPS(onePerTime);
    }

    /**
     * @return 直前のFPS
     */
    public double getLastFPS() {
        return timeToFPS(lastTime);
    }

    public double timeToFPS(long time) {
        return 1000000000d / (double) time;
    }
}
