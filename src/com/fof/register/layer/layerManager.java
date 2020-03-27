package com.fof.register.layer;

import com.fof.graphics.layer;

import java.util.HashMap;
import java.util.Map;

public class layerManager {
    public static layerManager INSTANCE = new layerManager();

    private Map<String, layer> layers = new HashMap<String, layer>();


    public layer getlayerbyid(String id) {
        return layers.get(id);
    }

    public void register(layer layer, String name) {
        layers.put(name, layer);
    }
}
