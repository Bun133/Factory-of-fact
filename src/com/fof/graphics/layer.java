package com.fof.graphics;

import com.fof.register.layer.layerManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class layer implements IDrawable{
    public List<Drawable> drawableList=new ArrayList<Drawable>();

    public layer(String name,int id,layersProvider provider){
        layerManager.INSTANCE.register(this,name,id);
        provider.addlayer(this);
    }

    public void addDrawable(Drawable drawable){
        drawableList.add(drawable);
    }


    @Override
    public void draw(Graphics graphics) {
        for(Drawable drawable:drawableList){
            drawable.draw(graphics);
        }
    }
}
