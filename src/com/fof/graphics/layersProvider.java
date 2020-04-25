package com.fof.graphics;

import java.util.ArrayList;
import java.util.List;

public class layersProvider implements IlayerProvider {
    //public static layersProvider INSTANCE = new layersProvider();
    public layersProvider() {
    }

    private List<layer> layers = new ArrayList<layer>();

    @Override
    public void addlayer(layer layer) {
        layers.add(layer);
    }

    @Override
    public List<layer> getlayers() {
        return layers;
    }

    @Override
    public boolean requestUpdate() {
        for (layer layer : layers) {
            for (IDrawable drawable : layer.drawableList) {
                if (drawable.requestUpdate()) {
                    return true;
                }
            }
        }
        return false;
    }
}
