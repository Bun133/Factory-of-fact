package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.register.layer.layerManager;

import java.util.ArrayList;
import java.util.List;

public class layer implements IDrawable {
    public List<Drawable> drawableList = new ArrayList<Drawable>();
    String name;

    public layer(String name, layersProvider provider) {
        layerManager.INSTANCE.register(this, name);
        this.name = name;
        provider.addlayer(this);
    }

    public void addDrawable(Drawable drawable) {
        drawableList.add(drawable);
    }


    @Override
    public void draw(Display display) {
        fof_game.INSTANCE.LOGGER.println("layer:" + this.name + " is Drawing");
        for (IDrawable drawable : drawableList) {
            drawable.draw(display);
        }
    }
}