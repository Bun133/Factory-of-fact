package com.fof.game.debug;

import com.fof.graphics.Drawable;

import java.util.ArrayList;
import java.util.List;

public class DebugConsole {
    public DebugConsole() {
    }

    private List<DebugViewer> drawables = new ArrayList<DebugViewer>();

    public void addDebug(DebugViewer viewer) {
        drawables.add(viewer);
    }

    public List<Drawable> getDrawables() {
        return this.allGet();
    }

    private Drawable get(DebugViewer viewer) {
        return viewer.getDrawable();
    }

    private List<Drawable> allGet() {
        List<Drawable> returnable = new ArrayList<Drawable>();
        for (DebugViewer viewer : drawables) {
            returnable.add(get(viewer));
        }
        return returnable;
    }
}
