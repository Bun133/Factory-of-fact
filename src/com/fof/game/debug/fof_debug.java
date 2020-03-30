package com.fof.game.debug;

import com.fof.graphics.Drawable;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.util.file.FileMaster;

import java.io.IOException;
import java.util.Random;

public class fof_debug extends Thread {
    public layersProvider debug_provider = new layersProvider();
    public DebugDisplay debug_display = new DebugDisplay("Fof_Debug", 500, 300, debug_provider, false);
    private layer testLayer = new layer("test_layer", debug_provider);
    private Drawable drawable = new Drawable(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
    private Random r = new Random();

    public fof_debug() throws IOException {
    }

    @Override
    public void run() {
        while (true) {
            drawable.setPos(r.nextInt(), r.nextInt());
            debug_display.draw();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void start() {
        super.start();
        debug_display.getConsole().addDebug(debug_display.FPSGetter);
        testLayer.addDrawable(drawable);
    }
}
