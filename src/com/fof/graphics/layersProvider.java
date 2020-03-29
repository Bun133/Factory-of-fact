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
}
