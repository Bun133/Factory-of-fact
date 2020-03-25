package com.fof.graphics;

import com.fof.register.layer.layerManager;

import java.util.ArrayList;
import java.util.List;

public class layer {
    public List<IDrawable> drawableList=new ArrayList<IDrawable>();

    public layer(String name,int id,layersProvider provider){
        layerManager.INSTANCE.register(this,name,id);
        provider.addlayer(this);
    }

    public void addDrawable(IDrawable drawable){
        drawableList.add(drawable);
    }


}
