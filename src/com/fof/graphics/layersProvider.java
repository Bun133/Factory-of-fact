package com.fof.graphics;

import java.util.HashMap;
import java.util.Map;

public class layersProvider implements IlayerProvider{
    public static layersProvider INSTANCE=new layersProvider();
    private Map<Integer,layer> layers=new HashMap<Integer,layer>();

    @Override
    public void addlayer(layer layer,int id) {
        layers.put(id,layer);
    }

    @Override
    public layer[] getlayers() {
        return layers.values().toArray(new layer[0]);
    }
}
