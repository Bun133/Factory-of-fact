package com.fof.object.item;

import com.fof.events.RegisterEvent;
import com.fof.graphics.Drawable;
import com.fof.register.IRegistrable;
import com.fof.register.graphics.TextureManager;

import java.awt.*;

public class Item implements IRegistrable {
    public String name;
    public int id;

    public Item(String name,int id){this.name=name;this.id=id;}
    public Item(String name,int id,Image image){
        TextureManager.INSTANCE.addTexture(this,image);
        this.name=name;
        this.id=id;
    }

    @Override
    public void register(RegisterEvent event) {
        //register Event
    }

    public Item setTexture(Image image){
        TextureManager.INSTANCE.addTexture(this,image);
        return this;
    }

    public Drawable getDrawable(){
        return new Drawable(TextureManager.INSTANCE.getTexture(this));
    }
}
