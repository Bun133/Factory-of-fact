package com.fof.graphics.map;

import com.fof.graphics.Display;
import com.fof.graphics.IDrawable;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.map.Map;

public class MapDrawer extends layer implements IDrawable {
    public MapDrawer(String name, layersProvider provider, Map MAP) {
        super(name, provider);
        this.map = MAP;
    }

    public Map map;

    @Override
    public void draw(Display display) {
        map.draw(display);
    }
}
