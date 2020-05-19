package com.fof.graphics.util;

import com.fof.graphics.Drawable;
import com.fof.map.pos.onDisplayPos;

import java.awt.*;

public class FPSMonitor implements IMonitor, IFPSListener {

    private onDisplayPos pos = new onDisplayPos(100, 100);

    private FPSGetter FPSG;

    public FPSMonitor(FPSGetter FPSG) {
        this.FPSG = FPSG;
        FPSG.listener.addListener(this);
    }

    @Override
    public Drawable getDrawable() {
        this.isRequestUpdate = false;
//        fof_game.INSTANCE.LOGGER.println("Drawing...");
        return this.f == null ? new Drawable(Integer.toString((int) this.FPSG.getFPS()), pos) : new Drawable(f, Integer.toString((int) this.FPSG.getFPS()), pos);
    }

    private Font f = null;

    public FPSMonitor setFont(Font font) {
        this.f = font;
        return this;
    }

    public boolean isRequestUpdate = true;

    @Override
    public void onFPSChange(FPSGetter fpsGetter) {
        this.isRequestUpdate = true;
    }
}
