package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.register.layer.layerManager;

import java.util.ArrayList;
import java.util.List;

public class layer implements IDrawable{
    public List<Drawable> drawableList=new ArrayList<Drawable>();
    String name;
    int id;

    public layer(String name,int id,layersProvider provider){
        layerManager.INSTANCE.register(this,name,id);
        this.name=name;
        this.id=id;
        provider.addlayer(this,id);
    }

    public void addDrawable(Drawable drawable){
        drawableList.add(drawable);
    }


    @Override
    public void draw(Display display) {
        fof_game.INSTANCE.LOGGER.println("layer:"+this.name+" is Drawing");
        for(IDrawable drawable:drawableList){
            drawable.draw(display);
        }
    }
}
