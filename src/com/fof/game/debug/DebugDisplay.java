package com.fof.game.debug;

import com.fof.graphics.Display;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;

import java.util.ArrayList;
import java.util.List;

public class DebugDisplay extends Display {
    public DebugDisplay(int Size_x, int Size_y, layersProvider provider) {
        super(Size_x, Size_y, provider);
    }

    public DebugDisplay(int Size_x, int Size_y, layersProvider provider, boolean bool) {
        super(Size_x, Size_y, provider);
        this.setVisible(bool);
    }

    public DebugDisplay(String name, int Size_x, int Size_y, layersProvider provider) {
        super(name, Size_x, Size_y, provider);
    }

    /*public DebugDisplay(String name, int Size_x, int Size_y, layersProvider provider,boolean bool) {
        super(name, Size_x, Size_y, provider);
        this.setVisible(bool);
    }*/

    public DebugDisplay(String name, int Size_x, int Size_y, layersProvider provider, boolean ForceBanSkip) {
        super(name, Size_x, Size_y, provider, ForceBanSkip);
    }

    @Override
    public void draw() {
        super.draw();
    }

    private layer DebugLayer = new layer("DebugLayer", this.provider);

    @Override
    protected void draw(List<layer> list) {
        DebugLayer.addDrawableAll(Console.getDrawables());
        List<layer> list1 = new ArrayList<layer>();
        list1.add(DebugLayer);
        super.draw(list1);
    }

    private layer getDebugLayer() {
        return this.DebugLayer;
    }

    private DebugConsole Console = new DebugConsole();

    public DebugConsole getConsole() {
        return Console;
    }
}
