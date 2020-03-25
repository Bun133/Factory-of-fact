package com.fof.map;

import com.fof.graphics.IDrawable;
import com.fof.graphics.layer;

public class Map extends layer implements IDrawable {
    @Override
    public layer draw() {
        // Pass to Graphics this(layer)
        return this;
    }
}
