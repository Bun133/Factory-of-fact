package com.fof.register.layer;

import com.fof.graphics.layer;

import java.util.HashMap;
import java.util.Map;

public class layerManager {
    public static layerManager INSTANCE=new layerManager();

    private Map<String,layer> layers=new HashMap<String,layer>();
    private Map<Integer,String> layer_string=new HashMap<Integer, String>();
    public layer getlayerbyid(int id){
        return getlayerbyid(getnamebyid(id));
    }

    private String getnamebyid(int id) {
        return layer_string.get(id);
    }

    public layer getlayerbyid(String id){
        return layers.get(id);
    }

    public void register(layer layer,String name,int id){
        layers.put(name,layer);
        layer_string.put(id,name);
    }
}
